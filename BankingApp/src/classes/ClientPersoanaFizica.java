package classes;
import java.util.Date;

public final class ClientPersoanaFizica extends Persoana implements ActiuniClient{
    private final Integer ID;
    private Cont cont = null;

    public ClientPersoanaFizica(String cNP, String nume, String prenume, Date dataNastere) {
        super(cNP, nume, prenume, dataNastere);
        this.ID = ActiuniClient.generateAccID();
        this.cont = new Cont(this.ID);
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
    public Integer getID() {
        return this.ID;
    }

    

    
    
    

    
        
}
