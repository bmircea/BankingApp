package classes;

import java.util.Random;

public class Utilitare {
    public enum TxState {
        SENT,
        PROCESSED,
        FAILED
    }

    public enum LoanState{
        APPROVAL,
        ONGOING,
        FINISHED
    }

    public enum LoanType{
        PERSONAL,
        MORTGAGE,
        CAR
    }

    public static Integer getRand(Integer bound){
        Random rnd = new Random();
        return rnd.nextInt(bound);
    }
}
