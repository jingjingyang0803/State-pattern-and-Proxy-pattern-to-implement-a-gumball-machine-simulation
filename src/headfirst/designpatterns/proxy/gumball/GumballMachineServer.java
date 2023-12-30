package headfirst.designpatterns.proxy.gumball;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GumballMachineServer {
	public static void main(String[] args) {
		try {
			// Create the first instance of the gumball machine
			GumballMachine gumballMachine1 = new GumballMachine("Main Street", 100);
			gumballMachine1.insertQuarter();

			// Create the second instance of the gumball machine
			GumballMachine gumballMachine2 = new GumballMachine("Park Avenue", 200);
			gumballMachine2.insertQuarter();
			gumballMachine2.turnCrank();

			// Start the RMI registry on the default port (1099)
			Registry registry = LocateRegistry.createRegistry(1099);

			// Bind the first gumball machine to a name in the registry using Naming.rebind()
			Naming.rebind("rmi://localhost/GumballMachine1", gumballMachine1);

			// Bind the second gumball machine to another name in the registry using Naming.rebind()
			Naming.rebind("rmi://localhost/GumballMachine2", gumballMachine2);

			System.out.println("Gumball machines are ready.");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

