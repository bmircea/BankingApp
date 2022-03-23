package classes;
import java.util.Date;

public final class ClientPersoanaFizica extends Client {
    private final String CNP;
    private String nume;
    private String prenume;
    private Date dataNastere;

    public ClientPersoanaFizica(String cNP, String nume, String prenume, Date dataNastere) {
        super();
        CNP = cNP;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNastere = dataNastere;
    }

    @Override
    public String toString() {
        return "ClientPersoanaFizica [CNP=" + CNP + ", dataNastere=" + dataNastere + ", nume=" + nume + ", prenume="
                + prenume + "]";
    }

    
    
    

    
        
}
