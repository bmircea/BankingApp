package classes;

import classes.Utilitare.LoanType;


public interface ActiuniClient{    
    
    public Integer getID();

    public Cont getCont();

    public String toString();

    public void addLoan(Integer durationM, Double value, LoanType type);
    
    public static void transfer(Cont sender, Cont receiver, Double value){
        // Intrabank
        sender.debitare(value);  
        receiver.creditare(value); 
    }

    public static void transfer(ActiuniClient sender, String peerAccount, Double value){
        // Interbank send
        sender.getCont().debitare(value); 
    }

    public static void transfer(ActiuniClient receiver, Double value){
        // Interbank receive
        receiver.getCont().creditare(value);
    }



    
}
