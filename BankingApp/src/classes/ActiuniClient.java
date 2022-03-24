package classes;

import java.util.Random;

public interface ActiuniClient{    
    public static Integer generateAccID(){
        Random rdn = new Random();
        return rdn.nextInt(100000);
    }

    public Integer getID();

    public Cont getCont();

    public String toString();
    
    public static void transfer(ActiuniClient sender, ActiuniClient receiver, double value){
        sender.getCont().debitare(value);  // TODO Create exceptions
        receiver.getCont().creditare(value); // TODO Create transactions
    }


    /*
    @Override
    public final void debitare(Double value){
        this.cont.debitare(value);
    }

    @Override
    public final void creditare(Double value){
        this.cont.creditare(value);
    }
    */



    
}
