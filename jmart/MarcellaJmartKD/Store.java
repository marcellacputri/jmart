package MarcellaJmartKD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable implements FileParser
{
    public static final String REGEX_PHONE = "^\\d{9, 12}$";
    public static final String REGEX_NAME = "^[A-Z](?!.*(\\s)\\1).{4,20}$";
    public String name;
    public String address;
    public String phoneNumber;
    
    public Store(int accountId, String name, String address, String phoneNumber){
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name, String address, String phoneNumber){
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString(){
        return(
            "name: " + this.name +"\n" +
            "address: " + this.address + "\n" +
            "phoneNumber: " + this.phoneNumber + "\n"
        );
    }
    
 public boolean validate()
    {
        Pattern name = Pattern.compile(REGEX_NAME);
        Matcher matcher = name.matcher(this.name);
        Pattern phone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = phone.matcher(this.phoneNumber);
        boolean Matcher = matcher.find();
        boolean phoneMatcher = matcherPhone.find();
        
        if(Matcher == true && phoneMatcher == true)
        {
            return true;
        }
        return false;
    }
       
        
}
