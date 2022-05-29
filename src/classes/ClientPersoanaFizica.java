package classes;
import java.util.ArrayList;
import java.sql.Date;

import classes.Utilitare.LoanType;

public final class ClientPersoanaFizica extends PersoanaFizica implements ActiuniClient, SQLActions{
    private Cont cont;
    private ArrayList<Credit> loans;

    public ClientPersoanaFizica(String cNP, String nume, String prenume, Date dataNastere) {
        super(cNP, nume, prenume, dataNastere);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + String.valueOf(this.cont.getNumarCont());
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

    public static String getSelectQuery() {
        return "SELECT * FROM CLIENT";
    }

    

    

    
    
    

    
        
}
