package com.MarcellaJmartKD;


import java.lang.Object;
import java.util.Vector;
import java.util.function.Function;

/**
 * Write a description of class Complaint here.
 *
 * @author (Marcella Cinninthya Putri)
 * @version (15/11/2021)
 */

public class ObjectPoolThread<T> extends Thread{
    private boolean exitSignal = false;
    private Vector<T> objectPool = new Vector<>();
    private Function<T, Boolean> routine;

    public ObjectPoolThread(String name, Function<T, Boolean> routine){
        super(name);
        this.routine = routine;
    }

    public ObjectPoolThread(Function <T, Boolean> routine){
        this.routine = routine;
    }

    public synchronized void add(T object){
        objectPool.add(object);
        super.notify();
    }

    public synchronized void exit(){
        exitSignal = true;
        super.notify();
    }

    @Override
    public void run() {
        while(true){
            synchronized(this) {
                while(objectPool.isEmpty() && !exitSignal) {
                    try {
                        super.wait();
                    }
                    catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(exitSignal) {
                    break;
                }
            }

            for(int i=0; i<objectPool.size();++i) {
                if(routine.apply(objectPool.get(i))) {
                    objectPool.set(i, null);
                }
            }

            objectPool.removeIf(o -> o==null);
        }
    }
}


