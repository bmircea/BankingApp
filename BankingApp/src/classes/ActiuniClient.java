package classes;

import classes.Utilitare.LoanType;


public interface ActiuniClient{    
    
    public Integer getID();

    public Cont getCont();

    public String toString();

    public void addLoan(Integer durationM, Double value, LoanType type);
    
    public static void transfer(ActiuniClient sender, ActiuniClient receiver, double value){
        // Intrabank
        sender.getCont().debitare(value);  // TODO Create exceptions
        receiver.getCont().creditare(value); // TODO Create transactions
    }

    public static void transfer(ActiuniClient sender, String peerAccount, Double value){
        // Interbank send
        sender.getCont().debitare(value);  // TODO Create tx, excep
    }

    public static void transfer(ActiuniClient receiver, Double value){
        // Interbank receive
        receiver.getCont().creditare(value);
    }



    
}
