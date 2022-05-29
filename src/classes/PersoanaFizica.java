package classes;

import java.sql.Date;

public abstract class PersoanaFizica extends Persoana {
    private final String CNP;
    private String nume;
    private String prenume;
    private Date dataNastere;

    public PersoanaFizica(String CNP, String nume, String prenume, Date dataNastere) {
        super();
        this.CNP = CNP;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNastere = dataNastere;
    }

    public PersoanaFizica(Integer ID, String CNP, String nume, String prenume, Date dataNastere) {
        super(ID);
        this.CNP = CNP;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNastere = dataNastere;
    }

    @Override
    public String toString() {
        return super.toString() + "CNP=" + CNP + ", dataNastere=" + dataNastere + ", nume=" + nume + ", prenume=" + prenume;
    }

    

    
}
