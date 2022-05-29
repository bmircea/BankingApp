package classes;

import java.sql.Date;

public final class Angajat extends PersoanaFizica implements SQLActions{
    private String departament;
    private Sucursala sucursala;

    public Angajat(String cNP, String nume, String prenume, Date dataNastere, String departament, Sucursala sucursala) {
        super(cNP, nume, prenume, dataNastere);
        this.departament = departament;
        this.sucursala = sucursala;
    }

    @Override
    public String toString() {
        return ", departament=" + departament + ", sucursala=" + sucursala.toString();
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
        // TODO Auto-generated method stub
        return null;
    }

    

    

    
    
    
}
