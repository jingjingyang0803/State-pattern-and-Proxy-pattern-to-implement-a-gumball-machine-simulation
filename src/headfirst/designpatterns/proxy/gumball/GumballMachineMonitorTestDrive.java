package headfirst.designpatterns.proxy.gumball;

import java.rmi.*;

public class GumballMachineMonitorTestDrive {
	public static void main(String[] args) {
		try {
			// Get a reference to the Gumball Machine remote objects from the registry using Naming.lookup()
			GumballMachineRemote gumballMachine1Remote = (GumballMachineRemote) Naming.lookup("rmi://localhost/GumballMachine1");
			GumballMachineRemote gumballMachine2Remote = (GumballMachineRemote) Naming.lookup("rmi://localhost/GumballMachine2");

			// Create GumballMonitor objects for each remote machine
			GumballMonitor gumballMonitor1 = new GumballMonitor(gumballMachine1Remote);
			GumballMonitor gumballMonitor2 = new GumballMonitor(gumballMachine2Remote);

			// Generate reports for each remote machine
			gumballMonitor1.report();
			gumballMonitor2.report();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
