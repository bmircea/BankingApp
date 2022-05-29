package classes;

import java.sql.Date;
import classes.Utilitare.TxState;

public final class Tranzactie implements SQLActions{
    private Integer ID;
    private java.util.Date timestamp;
    private Cont receiverAccount, senderAccount;
    private Double value;
    private TxState state;
    private String peerAccount;

    public Tranzactie(Cont receiverAccount, Cont senderAccount, Double value) {
        this.ID = Utilitare.getRand(10000);
        this.timestamp = null;
        this.receiverAccount = receiverAccount;
        this.senderAccount = senderAccount;
        this.value = value;
        this.state = TxState.SENT;
        this.peerAccount = null;
    }

    public Tranzactie(String receiverAccount, Cont senderAccount, Double value){
        this.ID = Utilitare.getRand(10000);
        this.timestamp = new java.util.Date();
        this.receiverAccount = null;
        this.peerAccount = receiverAccount;
        this.value = value;
        this.state = TxState.SENT;
        this.receiverAccount = null;
    }

    @Override
    public String toString() {
        return "receiverAccount=" + receiverAccount.toString() + ", senderAccount=" + senderAccount.toString() + ", state="
                + String.valueOf(state.ordinal()) + ", timestamp=" + timestamp + ", value=" + value.toString();
    }

    public Integer getID(){
        return this.ID;
    }

    @Override
    public String getInsertQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUpdateQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDeleteQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    public static String getSelectQuery(){
        return "SELECT * FROM TRANZACTIE";
    }


    

    

    

}
