package classes;

public interface OperatiuniCont {
    public Double getSold();
    public void debitare(Double value);
    public void creditare(Double value);

    public static void transfer(Cont sender, Cont receiver, double value){
        sender.debitare(value);  // TODO Create exceptions
        receiver.creditare(value); // TODO Create transactions
    }

    public static void transfer(Client sender, Client receiver, double value){
        sender.debitare(value);  // TODO Create exceptions
        receiver.creditare(value); // TODO Create transactions
    }
}
