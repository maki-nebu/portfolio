import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Task extends Remote {
    void executeTask() throws RemoteException;
}
