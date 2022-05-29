package classes;

import java.util.ArrayList;

import classes.Utilitare.LoanType;

public final class ClientPersoanaJuridica extends PersoanaJuridica implements ActiuniClient, SQLActions{
    private Cont cont;
    private ArrayList<Credit> loans;

    public ClientPersoanaJuridica(long cUI, String denumire) {
        super(cUI, denumire);
        this.cont = null;
        this.loans = null;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.cont.getNumarCont();
    }

    @Override
    public Cont getCont() {
        return this.cont;
    }

    @Override
    public void addLoan(Integer durationM, Double value, LoanType type) {
        if (loans == null){
            loans = new ArrayList<Credit>();
        }

        loans.add(new Credit(durationM, value, type));
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
