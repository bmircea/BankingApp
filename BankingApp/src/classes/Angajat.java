package classes;


public final class Angajat {
    private String departament;
    private Sucursala sucursala;

    public Angajat(String departament, Sucursala sucursala) {
        this.departament = departament;
        this.sucursala = sucursala;
    }

    @Override
    public String toString() {
        return "Angajat [departament=" + departament + ", sucursala=" + sucursala + "]";
    }

    

    
    
    
}
