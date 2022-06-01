package classes;

import java.util.ArrayList;

import classes.Utilitare.LoanType;

public final class ClientPersoanaJuridica extends PersoanaJuridica implements ActiuniClient, SQLActions{
    private Cont cont;
    private ArrayList<Credit> loans;


    public ClientPersoanaJuridica(String cUI, String denumire) {
        super(cUI, denumire);
        this.cont = new Cont(this.getID());
        this.loans = null;
    }

    public ClientPersoanaJuridica(Integer ID, String cUI, String denumire, Cont cont){
        super(ID, cUI, denumire);
        this.cont = cont;
    }

    @Override
    public String toString() {
        return super.toString() + ", numarCont=\"" + this.cont.getNumarCont() + "\"";
    }

    public String toStringStripCols(){
        return super.toStringStripCols() + ",\"" + this.cont.getNumarCont() + "\"";
    }

    @Override
    public Cont getCont() {
        return this.cont;
    }

    public void setCont(Cont c) {
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
        return "UPDATE CLIENT SET " + this.toString() + ";";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM CLIENT WHERE ID = " + this.getID().toString() + ");";
    }

    public static String getSelectQuery() {
        return "SELECT * FROM CLIENT";
    }

    

    

    
    
}
