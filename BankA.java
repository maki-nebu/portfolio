import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BankA extends UnicastRemoteObject implements Bank {
    private Map<String, Double> accounts;

    public BankA() throws RemoteException {
        accounts = new HashMap<>();
        accounts.put("A123", 1000.0);
        accounts.put("A456", 2000.0);
    }

    private boolean accountExists(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Error: Account " + accountNumber + " does not exist at Bank A.");
            return false;
        }
        return true;
    }

    @Override
    public void deposit(String accountNumber, double amount) throws RemoteException {
        if (!accountExists(accountNumber)) return;
        accounts.put(accountNumber, accounts.get(accountNumber) + amount);
        System.out.println("Deposited " + amount + " to account " + accountNumber + " at Bank A.");
    }

    @Override
    public void withdraw(String accountNumber, double amount) throws RemoteException {
        if (!accountExists(accountNumber)) return;
        if (accounts.get(accountNumber) >= amount) {
            accounts.put(accountNumber, accounts.get(accountNumber) - amount);
            System.out.println("Withdrew " + amount + " from account " + accountNumber + " at Bank A.");
        } else {
            System.out.println("Insufficient balance in account " + accountNumber + " at Bank A.");
        }
    }

    @Override
    public double checkBalance(String accountNumber) throws RemoteException {
        if (!accountExists(accountNumber)) return 0;
        return accounts.get(accountNumber);
    }
}
