package com.MarcellaJmartKD.controller;

import com.MarcellaJmartKD.dbjson.JsonAutowired;
import com.MarcellaJmartKD.dbjson.JsonTable;
import com.MarcellaJmartKD.ObjectPoolThread;
import com.MarcellaJmartKD.*;
import com.MarcellaJmartKD.Payment;
import com.MarcellaJmartKD.Invoice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>
{
    @JsonAutowired(value=Payment.class, filepath = "D:/jmart/src/main/Payment.json")
    public static JsonTable<Payment> PaymentTable;

    public static final long DELIVERED_LIMIT_MS = 100;
    public static final long ON_DELIVERY_LIMIT_MS = 100;
    public static final long ON_PROGRESS_LIMIT_MS = 100;
    public static final long WAITING_CONF_LIMIT_MS = 100;
    JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>("Thread", PaymentController::timekeeper);


    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/{id}/accept")
    public boolean accept
            (
                @RequestParam int id
            )
    {
        for(Payment each : paymentTable)
        {
            if(each.id == id)
            {
                if(each.history.get(each.history.size()-1).status == Invoice.Status.WAITING_CONFIRMATION)
                {
                    each.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, null));
                    return true;
                }
            }
        }
        return false;
    }

    @PostMapping(" /{id}/cancel ")
    @ResponseBody boolean cancel
            (
                    @RequestParam int id
            )
    {
        for(Payment each : paymentTable)
        {
            if(each.id == id)
            {
                if(each.history.get(each.history.size()-1).status == Invoice.Status.WAITING_CONFIRMATION)
                {
                    each.history.add(new Payment.Record(Invoice.Status.CANCELLED, null));
                    return true;
                }
            }
        }
        return false;
    }

    @PostMapping("/create")
    @ResponseBody Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int productId,
                    @RequestParam int productCount,
                    @RequestParam String shipmentAddress,
                    @RequestParam byte shipmentPlan
            )
    {
        for(Account account : AccountController.accountTable)
        {
            if(account.id == buyerId)
            {
                for(Product product : ProductController.productTable)
                {
                    if(product.accountId == productId)
                    {
                        Payment newPayment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0, shipmentPlan, null));
                        double totalPay = newPayment.getTotalPay(product);
                        if(account.balance >= totalPay)
                        {
                            account.balance -= totalPay;
                            newPayment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "WAITING_CONFIRMATION"));
                            paymentTable.add(newPayment);
                            poolThread.add(newPayment);
                            return newPayment;
                        }
                    }
                }
            }
        }
        return null;
    }

    @PostMapping(" /{id}/submit ")
    @ResponseBody boolean submit
            (
                    @RequestParam int id,
                    @RequestParam String receipt
            )
    {
        for(Payment each : paymentTable)
        {
            if(each.id == id)
            {
                if(each.history.get(each.history.size()-1).status == Invoice.Status.ON_PROGRESS)
                {
                    if(!receipt.isBlank())
                    {
                        each.shipment.receipt = receipt;
                        each.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, null));
                        return true;
                    }
                }
            }
        }
        return false;
    }



    private static boolean timekeeper(Payment payment)
    {
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        long elapsed = System.currentTimeMillis() - record.date.getTime();
        if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
            record.status = Invoice.Status.FAILED;
            return true;
        } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
            record.status = Invoice.Status.FAILED;
            return true;
        } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
            record.status = Invoice.Status.FINISHED;
            return true;
        } else if (record.status.equals(Invoice.Status.FINISHED) && (elapsed > DELIVERED_LIMIT_MS)) {
            record.status = Invoice.Status.FINISHED;
            return true;
        } else {
            return false;
        }
    }
}