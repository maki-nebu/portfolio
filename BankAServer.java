import java.rmi.Naming;
import java.rmi.RemoteException;

public class BankAServer {
    public static void main(String[] args) {
			System.setProperty("java.rmi.server.hostname", "192.168.254.201");

        try {
            // Create BankA instance
            BankA bankA = new BankA();

            // Bind BankA to the RMI registry with a simple name
            Naming.rebind("//192.168.254.201:1099/BankA", bankA);

            System.out.println("Bank A server is running...");
        } catch (Exception e) {
            System.err.println("Error starting Bank A server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
