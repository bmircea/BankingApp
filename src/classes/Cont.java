package classes;

public final class Cont implements OperatiuniCont{
    private final String numarCont;
    private Double sold;
    

    public Cont(Integer ClientID) {
        this.numarCont = "RO22BTLRRONCRT" + ClientID.toString(); // TODO O implementare mai buna, conturi in EUR, USD
        this.sold = 0.0;
    }
    
    @Override
    public final Double getSold(){
        return this.sold;
    }

    @Override
    public String getNumarCont() {
        return this.numarCont;
        
    }

    @Override
    public String toString() {
        return this.numarCont;
    }

    @Override
    public void creditare(Double value) {
        this.sold += value;
    }

    @Override
    public void debitare(Double value) {
        this.sold -= value;
    }



    

    

    
    
}
