package Assignment2;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class JobScheduler {
    private int[][] processes; // Stores arrival time and burst time for each process
    private int[] completionTime;
    private int[] waitingTime;
    private int[] turnaroundTime;
	//Constructors
    public JobScheduler(int[][] processes) {
        this.processes = processes;
        this.completionTime = new int[processes.length];
        this.waitingTime = new int[processes.length];
        this.turnaroundTime = new int[processes.length];
    }

    /**
     * Calculates completion time using First-Come-First-Serve (FCFS) scheduling.
     */
    public void calculateCompletionTime() {
        int currentTime = 0;  

        for (int i = 0; i < processes.length; i++) {
            if (processes[i][0] > currentTime) { 
                currentTime = processes[i][0];  
            }
            currentTime += processes[i][1];  
            completionTime[i] = currentTime; 
        }
    }

    /**
     * Calculates waiting time for each process.
     */
    public void calculateWaitingTime() {
        for (int i = 0; i < processes.length; i++) {
            waitingTime[i] = completionTime[i] - processes[i][0] - processes[i][1];
            if (waitingTime[i] < 0) {
                waitingTime[i] = 0;  
            }}}
    /**
     * Calculates turnaround time for each process.
     */
    public void calculateTurnaroundTime() {
        for (int i = 0; i < processes.length; i++) {
            turnaroundTime[i] = completionTime[i] - processes[i][0];
        }
    }
    /**
     * Calculates the average waiting time.
     */
    public double calculateAverageWaitingTime() {
        int totalWaitingTime = 0;
        for (int time : waitingTime) {
            totalWaitingTime += time;
        }
        return (double) totalWaitingTime / processes.length;
    }
    /**
     * Finds the maximum waiting time.
     */
    public int findMaximumWaitingTime() {
        int maxTime = 0;
        for (int time : waitingTime) {
            if (time > maxTime) {
                maxTime = time;
            }
        }
        return maxTime;
    }

    public int[] getCompletionTime() {
        return completionTime;
    }

    public int[] getWaitingTime() {
        return waitingTime;
    }

    public int[] getTurnaroundTime() {
        return turnaroundTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numProcesses = 0;

        // Getting the number of processes with input validation
        while (true) {
            try {
                System.out.print("Enter the number of processes: ");
                numProcesses = scanner.nextInt();
                if (numProcesses <= 0) {
                    System.out.println("Number of processes must be positive. Try again.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();  
            }
        }

        int[][] processes = new int[numProcesses][2];

        // Taking input for arrival time and burst time
        for (int i = 0; i < numProcesses; i++) {
            while (true) {
                try {
                    System.out.print("Process " + (i + 1) + " arrival time: ");
                    processes[i][0] = scanner.nextInt();
                    if (processes[i][0] < 0) {
                        System.out.println("Arrival time cannot be negative. Try again.");
                        continue;
                    }

                    System.out.print("Process " + (i + 1) + " burst time: ");
                    processes[i][1] = scanner.nextInt();
                    if (processes[i][1] <= 0) {
                        System.out.println("Burst time must be greater than zero. Try again.");
                        continue;
                    }

                    break;  
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter numbers only.");
                    scanner.next();  
                }
            }
        }

        JobScheduler scheduler = new JobScheduler(processes);

        scheduler.calculateCompletionTime();
        scheduler.calculateWaitingTime();
        scheduler.calculateTurnaroundTime();

        // Menu-driven system with exception handling
        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Display Completion Times");
                System.out.println("2. Display Waiting Times");
                System.out.println("3. Display Turnaround Times");
                System.out.println("4. Display Average Waiting Time");
                System.out.println("5. Display Maximum Waiting Time");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Completion Times: " + Arrays.toString(scheduler.getCompletionTime()));
                        break;
                    case 2:
                        System.out.println("Waiting Times: " + Arrays.toString(scheduler.getWaitingTime()));
                        break;
                    case 3:
                        System.out.println("Turnaround Times: " + Arrays.toString(scheduler.getTurnaroundTime()));
                        break;
                    case 4:
                        System.out.printf("Average Waiting Time: %.2f\n", scheduler.calculateAverageWaitingTime());
                        break;
                    case 5:
                        System.out.println("Maximum Waiting Time: " + scheduler.findMaximumWaitingTime());
                        break;
                    case 6:
                        System.out.println("Exiting... Thank you!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();  
            }
        }
    }
}
