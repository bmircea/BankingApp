import main.Service;
import main.DatabaseConnection;
import main.Logger;

public final class App {
    public static Service s = null;
    public static DatabaseConnection dbconn = null;
    public static Logger logger = null;

    public static void main(String[] args) throws Exception {
        App.s = Service.getInstance();
        dbconn = DatabaseConnection.getConnection();
        Logger.setFilePath("");
        logger = Logger.getInstance();
    
        // CLI menu
        System.out.println("Banking App menu");
        System.out.println("Choose an option and press enter:");
        System.out.println("1. Employees");
        System.out.println("1. Employees");
        System.out.println("1. Employees");
        System.out.println("1. Employees");
        System.out.println("1. Employees");
        System.out.println("1. Employees");
        System.out.println("1. Employees");
        String name = System.console().readLine();

        System.out.println(name);
        
    }

    
}


