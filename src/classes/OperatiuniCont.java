package classes;

public interface OperatiuniCont {
    public Double getSold();
    public void setSold(Double value);
    public void debitare(Double value);
    public void creditare(Double value);
    public String getNumarCont();

    public static void transfer(Cont sender, Cont receiver, double value){
        sender.debitare(value);  // TODO Create exceptions
        receiver.creditare(value); // TODO Create transactions
    }
}
