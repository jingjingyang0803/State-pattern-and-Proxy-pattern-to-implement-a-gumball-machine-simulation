# Remote Proxy implementation of the Gumball Machine

This project demonstrates the use of the State pattern and Proxy pattern to implement a gumball machine simulation.

## Getting Started

The gumball machine simulation allows users to insert a quarter, turn the crank, and receive a gumball. The behavior of the machine depends on its current state, which can be one of the following:

- NoQuarterState: The machine is waiting for a quarter to be inserted.
- HasQuarterState: A quarter has been inserted, and the user can turn the crank.
- SoldState: The crank has been turned, and the machine is dispensing a gumball.
- SoldOutState: The machine is out of gumballs.
- WinnerState: The user is a winner and receives two gumballs for their quarter.

The simulation provides a remote interface and proxy for accessing the gumball machine remotely. The `GumballMonitor` class demonstrates the usage of the remote proxy to monitor the state and inventory of the machine.

## Project Structure

The project consists of the following files:

- **State.java**: This file defines the `State` interface, which declares the methods that all concrete state classes must implement. The methods include `insertQuarter()`, `ejectQuarter()`, `turnCrank()`, and `dispense()`.

  - **HasQuarterState.java**: This file defines the `HasQuarterState` class, which implements the `State` interface. It represents one of the possible states of the gumball machine when it has a quarter inserted.
  - **NoQuarterState.java**: This file defines the `NoQuarterState` class, which implements the `State` interface. It represents one of the possible states of the gumball machine when it has no quarter inserted.
  - **SoldOutState.java**: This file defines the `SoldOutState` class, which implements the `State` interface. It represents one of the possible states of the gumball machine when it is sold out.
  - **SoldState.java**: This file defines the `SoldState` class, which implements the `State` interface. It represents one of the possible states of the gumball machine when it is dispensing a gumball.
  - **WinnerState.java**: This file defines the `WinnerState` class, which implements the `State` interface. It represents one of the possible states of the gumball machine when a winner is selected.

- **GumballMachineRemote.java**: This file defines the `GumballMachineRemote` interface, which extends the `Remote` interface and declares remote methods that can be called by a client.
- **GumballMachine.java**: This file defines the `GumballMachine` class, which represents the context for the State pattern. It contains the states and their transitions, as well as methods for interacting with the machine.
- **GumballMonitor.java**: This file defines the `GumballMonitor` class, which acts as a Proxy for the `GumballMachine` class. It provides a simplified interface for clients to interact with the `GumballMachine` remotely.

- **GumballMachineServer.java**: This file contains the `main` method and is used to test the functionality of the `GumballMachine` class.
- **GumballMachineMonitorTestDrive.java**: This file contains the `main` method and is used to test the functionality of the `GumballMonitor` class.

In summary, these files work together to demonstrate the implementation of the Gumball Machine example using the State and Proxy design patterns. The GumballMachine class represents the context, the state classes represent the different states of the machine, and the GumballMonitor class acts as a proxy for remote access to the GumballMachine class.

## Usage

To run the gumball machine simulation, follow these steps:

1. Compile all the Java files in the project using the Java compiler.
2. Run the GumballMachineServer class to test the functionality of the GumballMachine class.

Output would be one of the below:

```
You inserted a quarter
You inserted a quarter
You turned...
A gumball comes rolling out the slot...
Gumball machines are ready.
```

```
You inserted a quarter
You inserted a quarter
You turned...
YOU'RE A WINNER! You get two gumballs for your quarter
A gumball comes rolling out the slot...
A gumball comes rolling out the slot...
Gumball machines are ready.
```

3. Open another terminal and run the GumballMachineMonitorTestDrive class to test the functionality of the GumballMonitor class.
   Output would be one of the below:

```
Gumball Machine: Main Street
Current inventory: 100 gumballs
Current state: waiting for turn of crank
Gumball Machine: Park Avenue
Current inventory: 199 gumballs
Current state: waiting for quarter
```

```
Gumball Machine: Main Street
Current inventory: 100 gumballs
Current state: waiting for turn of crank
Gumball Machine: Park Avenue
Current inventory: 198 gumballs
Current state: waiting for quarter

```
