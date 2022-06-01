package classes;
import java.util.ArrayList;
import java.sql.Date;

import classes.Utilitare.LoanType;

public final class ClientPersoanaFizica extends PersoanaFizica implements ActiuniClient, SQLActions{
    private Cont cont;
    private ArrayList<Credit> loans;

    public ClientPersoanaFizica(String cNP, String nume, String prenume, Date dataNastere) {
        super(cNP, nume, prenume, dataNastere);
        this.cont = new Cont(this.getID());
    }

    public ClientPersoanaFizica(Integer ID, String cNP, String nume, String prenume, Date dataNastere, Cont cont){
        super(ID, cNP, nume, prenume, dataNastere);
        this.cont = cont;
    }

    @Override
    public String toString() {
        return super.toString() + ", numarCont=\"" + String.valueOf(this.cont.getNumarCont()) + "\"";
    }

    public String toStringStripCols(){
        return super.toStringStripCols() + ", \"" + this.cont.getNumarCont() + "\"";
    }

    @Override
    public Cont getCont() {
        return this.cont;
    }

    public void setCont(Cont c){
        this.cont = c;
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
        return "INSERT INTO CLIENT VALUES (" + this.toStringStripCols() + ");";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE CLIENT SET " + this.toString() + " WHERE ID=" + this.getID().toString() + ";";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM CLIENT WHERE ID =" + this.getID().toString() + ";";
    }

    public static String getSelectQuery() {
        return "SELECT * FROM CLIENT";
    }


    

    

    
    
    

    
        
}
