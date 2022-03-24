package classes;

public final class ClientPersoanaJuridica extends PersoanaJuridica implements ActiuniClient{
    public final Integer ID;
    public Cont cont = null;

    public ClientPersoanaJuridica(Long cUI, String denumire) {
        super(cUI, denumire);
        this.ID = ActiuniClient.generateAccID();
        this.cont = new Cont(this.ID);
    }

    @Override
    public String toString() {
        return "ClientPersoanaJuridica" + super.toString();
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
