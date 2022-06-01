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
        return super.toString() + "cod=\"" + CNP + "\", dataNastere=STR_TO_DATE('" + dataNastere + "', '%Y-%m-%d'), nume1=\"" + nume + "\", nume2=\"" + prenume + "\"";
    }

    public String toStringStripCols() {
        return super.toStringStripCols() + "\"" + CNP + "\", \"" + nume + "\", \"" + prenume + "\", " + "STR_TO_DATE('" + dataNastere + "', '%Y-%m-%d')";
    }

    public String getCNP() {
        return CNP;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(Date dataNastere) {
        this.dataNastere = dataNastere;
    }

    

    

    
}
