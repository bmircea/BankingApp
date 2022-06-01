package main;
import java.util.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

import classes.*;

public final class Service {
    private HashMap<Integer, ActiuniClient> clients; 
    private HashMap<Integer, Tranzactie> txs;
    private HashMap<Integer, Angajat> employees;
    private HashMap<String,  Cont> accounts;
    private HashMap<Integer, Credit> loans;
    private HashMap<Integer, ATM> atm;
    private HashMap<Integer, Sucursala> offices;
    private static ArrayList<LoggableEvent> events;
    private static Service instance = null;
    
    private Service(){  // Private constructor - singleton
        startApp();
    }

    public static Service getInstance(){
        if (instance == null){
            instance = new Service();
        }
        return instance;
    }
    
    private final void loadData(){
        ResultSet rs = DatabaseConnection.read(Angajat.getSelectQuery());
        try {
            while (rs.next()){
                Angajat a = new Angajat(rs.getInt("ID"),
                                        rs.getString("cod"), 
                                        rs.getString("nume1"), 
                                        rs.getString("nume2"), 
                                        rs.getDate("dataNastere"), 
                                        rs.getString("departament"), 
                                        new Sucursala(rs.getString("locatie")));
                this.employees.put(a.getID(), a);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        rs = DatabaseConnection.read(Cont.getSelectQuery());
        try {
            while (rs.next()){
                Cont a = new Cont(rs.getString("numarCont"), rs.getDouble("sold"));
                this.accounts.put(a.getNumarCont(), a);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        rs = DatabaseConnection.read(ClientPersoanaFizica.getSelectQuery());
        try {
            while (rs.next()){
                if (rs.getString("nume2") == null){
                    ClientPersoanaJuridica c = new ClientPersoanaJuridica(rs.getInt("ID"),
                                                                          rs.getString("cod"),
                                                                          rs.getString("nume1"),
                                                                          accounts.get(rs.getString("numarCont")));
                    this.clients.put(c.getID(), c);
                } else {
                    ClientPersoanaFizica c = new ClientPersoanaFizica(rs.getInt("ID"),
                                                                      rs.getString("cod"), 
                                                                      rs.getString("nume1"), 
                                                                      rs.getString("nume2"), 
                                                                      Date.valueOf(rs.getString("dataNastere")),
                                                                      accounts.get(rs.getString("numarCont")));
                    this.clients.put(c.getID(), c);
                }
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        rs = DatabaseConnection.read(Tranzactie.getSelectQuery());
        try {
            while (rs.next()){
                Tranzactie a = new Tranzactie(rs.getInt("ID"), 
                                              accounts.get(rs.getString("receiverAccount")), 
                                              accounts.get(rs.getString("senderAccount")), 
                                              rs.getDouble("value"),
                                              rs.getString("timestamp"));
                this.txs.put(a.getID(), a);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private final void startApp(){
        this.clients = new HashMap<Integer, ActiuniClient>();
        this.txs = new HashMap<Integer, Tranzactie>();
        this.employees = new HashMap<Integer, Angajat>();
        this.accounts= new HashMap<String, Cont>();
        this.loans= new HashMap<Integer, Credit>();
        this.atm= new HashMap<Integer, ATM>();
        this.offices= new HashMap<Integer, Sucursala>();
        events = new ArrayList<LoggableEvent>();

        loadData();

        System.out.println("App running");
    }

    // Clients    
    public HashMap<Integer, ActiuniClient> getClients() {
        Logger.log("getClients");
        return clients;
    }

    public ActiuniClient getClient(Integer ID){  
        Logger.log("getClient");
        return clients.get(ID);                      
    }

    public void deleteClient(ActiuniClient cl){
        Logger.log("deletClient");
        if (cl instanceof ClientPersoanaFizica){
            DatabaseConnection.delete(String.format((((ClientPersoanaFizica)cl).getDeleteQuery()), String.valueOf(cl.getID())));
            
        }
        clients.remove(cl.getID());
    }

    public void addClient(Scanner in, Integer type){
        Logger.log("addClient");
        in.nextLine();
        ClientPersoanaFizica cf;
        ClientPersoanaJuridica cj;

        if (type == 1){  // persoane fizice
            String CNP, nume, prenume;
            Date dataNastere;
            
            System.out.println("CNP:");
            CNP = in.nextLine();
            System.out.println("Nume:");
            nume = in.nextLine();
            System.out.println("Prenume:");
            prenume = in.nextLine();
            System.out.println("Data Nastere:");
            dataNastere = Date.valueOf(in.nextLine());
            cf = new ClientPersoanaFizica(CNP, nume, prenume, dataNastere);
            accounts.put(cf.getCont().getNumarCont(), cf.getCont());
            clients.put(cf.getID(), cf);
            System.out.println(cf.getInsertQuery());
            DatabaseConnection.insert(cf.getInsertQuery());
            DatabaseConnection.insert(cf.getCont().getInsertQuery());
        } else {    // persoane juridice
            String denumire, cui;
            System.out.println("CUI:");
            cui = in.nextLine();
            System.out.println("Denumire");
            denumire = in.nextLine();
            cj = new ClientPersoanaJuridica(cui, denumire);
            clients.put(cj.getID(), cj);
            accounts.put(cj.getCont().getNumarCont(), cj.getCont());
            System.out.println(cj.getInsertQuery());
            DatabaseConnection.insert(cj.getInsertQuery());
            DatabaseConnection.insert(cj.getCont().getInsertQuery());
        }
        

    }

    public void updateClient(ActiuniClient cl, Scanner in, Integer type){
        in.nextLine();
        if (type == 1){  // persoane fizice
            System.out.println("Nume:");
            ((ClientPersoanaFizica)cl).setNume(in.nextLine());
            System.out.println("Prenume:");
            ((ClientPersoanaFizica)cl).setPrenume(in.nextLine());
            System.out.println("Data Nastere:");
            ((ClientPersoanaFizica)cl).setDataNastere(Date.valueOf(in.nextLine()));
            DatabaseConnection.insert(((ClientPersoanaFizica)cl).getUpdateQuery());
        } else {    // persoane juridice
            System.out.println("Denumire:");
            ((ClientPersoanaJuridica)cl).setDenumire(in.nextLine());
            DatabaseConnection.insert(((ClientPersoanaJuridica)cl).getUpdateQuery());
        }

    }

    // Transactions
    public HashMap<Integer, Tranzactie> getTxs() {
        Logger.log("getTxs");
        return txs;
    }

    public void deleteTx(Tranzactie tx){
        Logger.log("deleteTransaction");
        DatabaseConnection.delete(String.format(tx.getDeleteQuery(), tx.getID()));
        txs.remove(tx.getID());
    }

    public void addTx(Scanner in){
        in.nextLine();
        Logger.log("addTx");
        String reccont, sendercont;
        Double value;
        System.out.println("Receiver Account: " );
        reccont = in.nextLine();
        System.out.println("Sender Account: ");
        sendercont = in.nextLine();
        System.out.println("Value: ");
        value = in.nextDouble();
        Tranzactie tx = new Tranzactie(accounts.get(reccont), accounts.get(sendercont), value);
        txs.put(tx.getID(), tx);
        DatabaseConnection.insert(tx.getInsertQuery());

    }

    public void updateTx(Tranzactie tx, Scanner in){
        in.nextLine();
        Logger.log("updateTx");
        System.out.println("Receiver Account: " );
        tx.setReceiver(accounts.get(in.nextLine()));
        System.out.println("Sender Account: ");
        tx.setSender(accounts.get(in.nextLine()));
        System.out.println("Value: ");
        tx.setValue(in.nextDouble());
        txs.put(tx.getID(), tx);
        DatabaseConnection.insert(tx.getUpdateQuery());
    }

    // Employees
    public HashMap<Integer, Angajat> getEmployees() {
        Logger.log("getEmployees");
        return employees;
    }

    public void deleteEmployee(Angajat a){
        Logger.log("deleteEmployee");
        System.out.println(String.format(a.getDeleteQuery(), a.getID()));
        DatabaseConnection.delete(String.format(a.getDeleteQuery(), a.getID()));
        employees.remove(a.getID());
    }

    public void addEmployee(Scanner in){
        in.nextLine();
        Logger.log("addEmployee");
        String departament, sucursala, nume, prenume, CNP;
        String dataNastere;
        System.out.println("CNP: " );
        CNP = in.nextLine();
        System.out.println("Nume: ");
        nume = in.nextLine();
        System.out.println("Prenume: ");
        prenume = in.nextLine();
        System.out.println("Data nastere (ZZ-LL-AAAA):");
        dataNastere = in.nextLine();
        System.out.println("Departament:");
        departament = in.nextLine();
        System.out.println("Sucursala:");
        sucursala = in.nextLine();
        Angajat a = new Angajat(CNP, nume, prenume, Date.valueOf(dataNastere) , departament, new Sucursala(sucursala));
        employees.put(a.getID(), a);
        System.out.println(a.getInsertQuery());
        DatabaseConnection.insert(a.getInsertQuery());
    }

    public void updateEmployee(Angajat a, Scanner in){
        in.nextLine();
        Logger.log("updateEmployee");
        System.out.println("ID:" + a.getID());
        System.out.println("Nume: ");
        a.setNume(in.nextLine());
        System.out.println("Prenume: ");
        a.setPrenume(in.nextLine());
        System.out.println("Data nastere (ZZ-LL-AAAA):");
        a.setDataNastere(Date.valueOf(in.nextLine()));
        System.out.println("Departament:");
        a.setDepartament(in.nextLine());
        System.out.println("Sucursala:");
        a.setSucursala(new Sucursala(in.nextLine()));
        System.out.println(a.getUpdateQuery());
        DatabaseConnection.insert(a.getUpdateQuery());
    }

    // Accounts
    public HashMap<String, Cont> getAccounts() {
        Logger.log("getAccount"); 
        return accounts;
    }

    public Double getAccountBalance(Integer ID){
        Logger.log("getAccountBalance");
        return getClient(ID).getCont().getSold();
    }

    public Double getAccountBalance(ActiuniClient client){
        Logger.log("getAccountBalance");
        return client.getCont().getSold();
    }

    public void deleteAccount(Cont c){

        Logger.log("deleteAccount");
        DatabaseConnection.delete(String.format(c.getDeleteQuery(), c.getNumarCont()));
        accounts.remove(c.getNumarCont());        
    }

    public void addAccount(Scanner in){
        in.nextLine();
        Logger.log("addAccount");
        System.out.println("ID: " );
        Cont c = new Cont(in.nextInt());
        System.out.println("Sold:");
        c.setSold(in.nextDouble());
        accounts.put(c.getNumarCont(), c);
        DatabaseConnection.insert(c.getInsertQuery());
    }

    public void updateAccount(Cont c, Scanner in){
        Logger.log("updateAccount");
        System.out.println("ID: " + c.getNumarCont());
        System.out.println("Sold:");
        c.setSold(in.nextDouble());
        accounts.put(c.getNumarCont(), c);
        DatabaseConnection.update(c.getUpdateQuery());
    }

    // Loans
    public HashMap<Integer, Credit> getLoans() {
        Logger.log("getLoans");
        return loans;
    }

    // ATMs
    public HashMap<Integer, ATM> getATM() {
        Logger.log("getATM");
        return atm;
    }

    // Offices
    public HashMap<Integer, Sucursala> getOffices() {
        Logger.log("getOffices");
        return offices;
    }

    // Actions
    public void transferFunds(ActiuniClient sender, ActiuniClient receiver, Double value){
        Logger.log("transferFundsIntrabank");
        ActiuniClient.transfer(sender, receiver, value);
        Tranzactie tx = new Tranzactie(receiver.getCont(), sender.getCont(), value);
        txs.put(tx.getID(), tx);
    }

    public void transferFunds(ActiuniClient sender, String peerAccount, Double value){
        Logger.log("transferFundsInterbankSend");
        ActiuniClient.transfer(sender, peerAccount, value);
        Tranzactie tx = new Tranzactie(peerAccount, sender.getCont(), value);
        txs.put(tx.getID(), tx);
    }

    public void transferFunds(ActiuniClient receiver, Double value){
        Logger.log("transferFundsInterbankSend");
        ActiuniClient.transfer(receiver, value);
    }

    // Events

    public static void addEvent(LoggableEvent e){
        events.add(e);
    }

    public static ArrayList<LoggableEvent> getEvents(){
        return events;
    }
    






     
    
}
