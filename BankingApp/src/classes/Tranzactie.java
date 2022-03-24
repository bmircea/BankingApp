package classes;

import java.util.Date;
import classes.Utilitare.TxState;

public final class Tranzactie {
    private Date timestamp;
    private Cont receiverAccount, senderAccount;
    private Double value;
    private TxState state;

    public Tranzactie(Cont receiverAccount, Cont senderAccount, Double value, TxState state) {
        this.timestamp = new Date();
        this.receiverAccount = receiverAccount;
        this.senderAccount = senderAccount;
        this.value = value;
        this.state = TxState.SENT;
    }

    @Override
    public String toString() {
        return "Tranzactie [receiverAccount=" + receiverAccount + ", senderAccount=" + senderAccount + ", state="
                + state + ", timestamp=" + timestamp + ", value=" + value + "]";
    }

    

    

    

}
