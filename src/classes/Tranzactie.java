package classes;

import java.util.Date;
import classes.Utilitare.TxState;

public final class Tranzactie implements SQLActions{
    private Integer ID;
    private java.sql.Date timestamp;
    private Cont receiverAccount, senderAccount;
    private Double value;
    private TxState state;
    private String peerAccount;

    public Tranzactie(Cont receiverAccount, Cont senderAccount, Double value) {
        this.ID = Utilitare.getRand(10000);
        this.timestamp = new java.sql.Date(System.currentTimeMillis());
        this.receiverAccount = receiverAccount;
        this.senderAccount = senderAccount;
        this.value = value;
        this.state = TxState.SENT;
        this.peerAccount = null;
    }

    public Tranzactie(String receiverAccount, Cont senderAccount, Double value){
        this.ID = Utilitare.getRand(10000);
        this.timestamp = new java.sql.Date(System.currentTimeMillis());
        this.receiverAccount = null;
        this.peerAccount = receiverAccount;
        this.value = value;
        this.state = TxState.SENT;
        this.receiverAccount = null;
    }

    public Tranzactie(Integer ID, Cont receiverAccount, Cont senderAccount, Double value, String timestamp){
        this.ID = ID;
        this.receiverAccount = receiverAccount;
        this.senderAccount = senderAccount;
        this.value = value;
        this.timestamp = java.sql.Date.valueOf(timestamp);
        this.state = TxState.SENT;
    }

    @Override
    public String toString() {
        return "receiverAccount=\"" + receiverAccount.getNumarCont().toString() + "\", senderAccount=\"" + senderAccount.getNumarCont().toString() + "\", state="
                + String.valueOf(state.ordinal()) + ", timestamp=\"" + timestamp.toString() + "\", value=" + value.toString();
    }

    public String toStringStripCols(){
        return this.ID.toString() + ", \"" + receiverAccount.getNumarCont().toString() + "\", \"" + senderAccount.getNumarCont().toString() + "\", " + String.valueOf(state.ordinal()) + ", \"" + timestamp.toString() + "\", " + value.toString(); 
    }

    public Integer getID(){
        return this.ID;
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO TRANZACTIE VALUES (" + this.toStringStripCols() + ");";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE TRANZACTIE SET " + this.toString() + " WHERE ID = " + this.ID.toString()+ ";";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM TRANZACTIE WHERE ID="+this.ID.toString() + ";";
    }

    public static String getSelectQuery(){
        return "SELECT * FROM TRANZACTIE;";
    }

    public void setSender(Cont s){
        this.senderAccount = s;
    }

    public void setReceiver(Cont s){
        this.receiverAccount = s;
    }

    public void setValue(Double value){
        this.value = value;
    }


    

    

    

}
