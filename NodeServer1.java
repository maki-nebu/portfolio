import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class NodeServer1 extends UnicastRemoteObject implements Task {
    private static final String NODE_NAME = "SERVER1";

    public NodeServer1() throws RemoteException {
        super();
    }

    @Override
    public void executeTask() throws RemoteException {
        System.out.println("Task executed on: " + NODE_NAME);
    }

    public static void main(String[] args) {
        try {
            NodeServer1 node = new NodeServer1();
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            registry.rebind(NODE_NAME, node);
            System.out.println(NODE_NAME + " is ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
