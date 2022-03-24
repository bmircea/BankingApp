package classes;

import java.util.Date;

public abstract class Persoana {
    private final String CNP;
    private String nume;
    private String prenume;
    private Date dataNastere;

    public Persoana(String cNP, String nume, String prenume, Date dataNastere) {
        CNP = cNP;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNastere = dataNastere;
    }

    @Override
    public String toString() {
        return "[CNP=" + CNP + ", dataNastere=" + dataNastere + ", nume=" + nume + ", prenume=" + prenume
                + "]";
    }

    

    
}
