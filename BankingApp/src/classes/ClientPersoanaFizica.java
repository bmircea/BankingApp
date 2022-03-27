package classes;
import java.util.ArrayList;
import java.util.Date;

import classes.Utilitare.LoanType;

public final class ClientPersoanaFizica extends PersoanaFizica implements ActiuniClient{
    private Cont cont;
    private ArrayList<Credit> loans;

    public ClientPersoanaFizica(String cNP, String nume, String prenume, Date dataNastere) {
        super(cNP, nume, prenume, dataNastere);
    }

    @Override
    public String toString() {
        return "ClientPersoanaFizica" + super.toString();
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

    

    

    
    
    

    
        
}
