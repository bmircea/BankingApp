package classes;

import java.sql.Date;

public final class Angajat extends PersoanaFizica implements SQLActions{
    private String departament;
    private Sucursala sucursala;

    public Angajat(String CNP, String nume, String prenume, Date dataNastere, String departament, Sucursala sucursala) {
        super(CNP, nume, prenume, dataNastere);
        this.departament = departament;
        this.sucursala = sucursala;
    }

    public Angajat(Integer ID, String CNP, String nume, String prenume, Date dataNastere, String departament, Sucursala sucursala) {
        super(ID, CNP, nume, prenume, dataNastere);
        this.departament = departament;
        this.sucursala = sucursala;
    }

    @Override
    public String toString() {
        return super.toString() + ", departament=" + departament + sucursala.toString();
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public Sucursala getSucursala() {
        return sucursala;
    }

    public void setSucursala(Sucursala sucursala) {
        this.sucursala = sucursala;
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
        return "DELETE FROM ANGAJAT WHERE ID = %d";
    }

    public static String getSelectQuery() {
        return "SELECT * FROM ANGAJAT";
    }

    

    

    
    
    
}
