package classes;

import java.sql.Date;
import classes.Utilitare.TxState;

public final class Tranzactie implements SQLActions{
    private Integer ID;
    private Date timestamp;
    private Cont receiverAccount, senderAccount;
    private Double value;
    private TxState state;

    public Tranzactie(Cont receiverAccount, Cont senderAccount, Double value, TxState state) {
        this.ID = Utilitare.getRand(10000);
        this.timestamp = null;
        this.receiverAccount = receiverAccount;
        this.senderAccount = senderAccount;
        this.value = value;
        this.state = TxState.SENT;
    }

    @Override
    public String toString() {
        return "receiverAccount=" + receiverAccount.toString() + ", senderAccount=" + senderAccount.toString() + ", state="
                + String.valueOf(state.ordinal()) + ", timestamp=" + timestamp + ", value=" + value.toString();
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

    

    

    

}
