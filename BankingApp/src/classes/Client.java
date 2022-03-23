package classes;

import java.util.Random;

public abstract class Client implements OperatiuniCont{    
    private final Integer ID;
    private Cont cont = null;

    Client() {
        Random rdn = new Random();
        this.ID = rdn.nextInt(10^7-1);
        this.cont = new Cont(this.ID);
    }

    public final Integer getID(){
        return this.ID;
    }

    public final Double getSold(){
        return this.cont.getSold();
    }

    @Override
    public abstract String toString();

    @Override
    public final void debitare(Double value){
        this.cont.debitare(value);
    }

    @Override
    public final void creditare(Double value){
        this.cont.creditare(value);
    }



    
}
