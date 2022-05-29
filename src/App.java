import main.Service;

import java.util.HashMap;
import java.util.Scanner;

import classes.ActiuniClient;
import classes.Angajat;
import classes.ClientPersoanaFizica;
import classes.ClientPersoanaJuridica;
import classes.Tranzactie;
import main.DatabaseConnection;
import main.Logger;

public final class App {
    private static Service s = null;
    private static DatabaseConnection dbconn = null;
    private static Logger logger = null;
    private static Scanner in = null;
    private static Integer opt = null;
    private static Integer close = 0;
    public static void main(String[] args) throws Exception {
        App.s = Service.getInstance();
        //dbconn = DatabaseConnection.getConnection();
        Logger.setFilePath("C:\\Users\\Mircea\\Facultate\\Sem 2\\EAP\\BankingApp\\log.csv");
        logger = Logger.getInstance();
        in = new Scanner(System.in);

        // CLI menu
        System.out.println("Banking App menu");
        System.out.println("Choose an option and press enter:");
        mainMenu();       
        
    }

    private static void mainMenu(){
        System.out.println("1. Clients");
        System.out.println("2. Transactions");
        System.out.println("3. Accounts");
        System.out.println("4. Employees");
        System.out.println("0. Exit");

        while (close == 0){
        opt = in.nextInt();
        switch (opt){
            case 1:
                clientsMenu();
                mainMenu();
            break;
            case 2:
                txMenu();
                mainMenu();
            break;
            case 3:
                accountsMenu();
                mainMenu();
            break;
            case 4:
                employeesMenu();
                mainMenu();
            break;
            case 0:
                closeApp();
            break;
            default:
                defaultCase();
            break;
        }
        }
        
    }

    private static void clientsMenu(){
        clearConsole();
        System.out.println("1. Persoane Fizice");
        System.out.println("2. Persoane Juridice");
        System.out.println("0. Back");
        opt = in.nextInt();

        switch (opt){
            case 1:
                persFiziceMenu();
            break;
            case 2:
                persJuridiceMenu();
            break;
            case 0:
                mainMenu();
            break;
            default:
                defaultCase();
            break;
        }
    }

    private static void txMenu(){
        clearConsole();
        HashMap<Integer, Tranzactie> e = s.getTxs();
        for (Integer i: e.keySet()){
            Tranzactie t = e.get(i);
            System.out.println(String.format("%d %s", i, t.toString()));
        }
        System.out.println("1. Create transaction");
        System.out.println("0. Back");
        opt = in.nextInt();

        switch (opt){
            case 1:
                createTransaction();
            break;
            case 0:
                mainMenu();
            break;
            default:
                defaultCase();
            break;
        }
    }

    private static void accountsMenu(){
        clearConsole();
        System.out.println("0. Back");
        opt = in.nextInt();

        switch (opt){
            case 0:
                mainMenu();
            break;
            default:
                defaultCase();
            break;
        }
    }

    private static void employeesMenu(){
        clearConsole();
        HashMap<Integer, Angajat> e = s.getEmployees();
        for (Integer i: e.keySet()){
            Angajat a = e.get(i);
            System.out.println(String.format("%d %s", i, a.toString()));
        }
        System.out.println("1. Delete");
        System.out.println("2. Add");
        System.out.println("0. Back");
        opt = in.nextInt();

        switch (opt){
            case 1:
                Integer id = delete();
                s.deleteEmployee(e.get(id));
            break;
            case 2:
                add();
            break;
            case 0:
                mainMenu();
            break;
            default:
                defaultCase();
            break;
        }
    }

    private static void persFiziceMenu(){
        clearConsole();
        HashMap<Integer, ActiuniClient> h = s.getClients();
        for (Integer i: h.keySet()){
            ActiuniClient a = h.get(i);
            if (a instanceof ClientPersoanaFizica){
                System.out.println(String.format("%d %s", i, a.toString()));
            }
        }

        System.out.println("1. Delete");
        System.out.println("2. Add");
        System.out.println("0. Back");
        opt = in.nextInt();

        switch (opt){
            case 1:
                Integer id = delete();
                s.deleteClient(h.get(id));        
            break;
            case 2:
                add();
            break;
            case 0:
                clientsMenu();
            break;
            default:
                defaultCase();
            break;
        }
    }

    private static void persJuridiceMenu(){
        clearConsole();
        HashMap<Integer, ActiuniClient> h = s.getClients();
        for (Integer i: h.keySet()){
            ActiuniClient a = h.get(i);
            if (a instanceof ClientPersoanaJuridica){
                System.out.println(String.format("%d %s", i, a.toString()));
            }
        }
        System.out.println("1. Delete");
        System.out.println("2. Add");
        System.out.println("0. Back");
        opt = in.nextInt();

        switch (opt){
            case 1:
                Integer id = delete();
                s.deleteClient(h.get(id)); 
            break;
            case 2:
                add();
            break;
            case 0:
                clientsMenu();
            break;
            default:
                defaultCase();
            break;
        }
    }

    private static void closeApp(){
        Logger.dumpLog(Service.getEvents());
        close = 1;
    }

    private static void clearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name");
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private static void defaultCase(){
        System.out.println("Invalid opt");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clearConsole();
        mainMenu();
    }

    public static int delete(){
        System.out.println("Please input the id:");
        Integer id = in.nextInt();
        return id;
    }

    public static String deleteStr(){
        System.out.println("Please input the id:");
        String str = in.nextLine();
        return str;
    }

    public static void add(){
        
    }

    public static void createTransaction(){
        System.out.println("1. Intrabank");
        System.out.println("2. Interbank");
        opt = in.nextInt();
        switch (opt){
            case 1:
                intrabankTx();
            break;
            case 2:
                interbankTx();
            break;
            case 0:
                txMenu();
            default:
                defaultCase();
            break;
        }
    }

    public static void intrabankTx(){
        System.out.println("Sender ID:");
        Integer sender = in.nextInt();
        System.out.println("Receiver ID:");
        Integer receiver = in.nextInt();
        System.out.println("Value:");
        Double value = in.nextDouble();
        s.transferFunds(s.getClients().get(sender), s.getClients().get(receiver), value);

    }

    public static void interbankTx() {
        System.out.println("Sender ID:");
        Integer sender = in.nextInt();
        System.out.println("Receiver Account:");
        String receiver = in.nextLine();
        System.out.println("Value:");
        Double value = in.nextDouble();
        s.transferFunds(s.getClients().get(sender), receiver, value);
    }


 
    
}


