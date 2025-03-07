package Assignment2;
import java.util.Arrays;
import java.util.Scanner;
public class JobScheduler {

	    private int[][] processes; // Arrival time and burst time for each process
	    private int[] completionTime;
	    private int[] waitingTime; 
	    private int[] turnaroundTime; 

	    public JobScheduler(int[][] processes) {
	        this.processes = processes;
	        this.completionTime = new int[processes.length];
	        this.waitingTime = new int[processes.length];
	        this.turnaroundTime = new int[processes.length];
	    }

	    /**
	     * Calculates the completion time for each process using FCFS.
	     */
	    public void calculateCompletionTime() {
	        int currentTime = 0; // Keeps track of the current time

	        for (int i = 0; i < processes.length; i++) {
	            // if our arrival time process>current time
	            if (processes[i][0] > currentTime) {
	                currentTime = processes[i][0];
	            }

	            // Calculate completion time: current time + burst time
	            currentTime += processes[i][1];
	            completionTime[i] = currentTime;
	        }
	    }

	    /**
	     * Calculates the waiting time for each process.
	     */
	    public void calculateWaitingTime() {
	        for (int i = 0; i < processes.length; i++) {
	            // Waiting time = Completion time - Arrival time - Burst time
	            waitingTime[i] = completionTime[i] - processes[i][0] - processes[i][1];

	        }
	    }

	    /**
	     * Calculates the turnaround time for each process.
	     */
	    public void calculateTurnaroundTime() {
	        for (int i = 0; i < processes.length; i++) {
	            // Turnaround time = Completion time - Arrival time
	            turnaroundTime[i] = completionTime[i] - processes[i][0];
	        }
	    }

	    /**
	     * Calculates the average waiting time for all processes.
	     * @return the average waiting time.
	     */
	    public double calculateAverageWaitingTime() {
	        double totalWaitingTime = 0;
	        for (int time : waitingTime) {
	            totalWaitingTime += time;
	        }
	        return totalWaitingTime / processes.length;
	    }

	    /**
	     * Finds the maximum waiting time among all processes.
	     * @return the maximum waiting time.
	     */
	    public int findMaximumWaitingTime() {
	        int maxWaitingTime = 0;
	        for (int time : waitingTime) {
	            if (time > maxWaitingTime) {
	                maxWaitingTime = time;
	            }
	        }
	        return maxWaitingTime;
	    }



	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the number of processes: ");
	        int numProcesses = scanner.nextInt();

	        int[][] processes = new int[numProcesses][2];

	        System.out.println("Enter the arrival time and burst time for each process:");
	        for (int i = 0; i < numProcesses; i++) {
	            System.out.print("Process " + (i + 1) + " arrival time: ");
	            processes[i][0] = scanner.nextInt();
	            System.out.print("Process " + (i + 1) + " burst time: ");
	            processes[i][1] = scanner.nextInt();
	        }

	        JobScheduler scheduler = new JobScheduler(processes);

	        scheduler.calculateCompletionTime();
	        scheduler.calculateWaitingTime();
	        scheduler.calculateTurnaroundTime();

	   
	                    System.out.println("Completion Times: " + Arrays.toString(scheduler.completionTime));
	                    System.out.println("Waiting Times: " + Arrays.toString(scheduler.waitingTime));
	                    System.out.println("Turnaround Times: " + Arrays.toString(scheduler.turnaroundTime));
	                    System.out.println("Average Waiting Time: " + scheduler.calculateAverageWaitingTime());
	                    System.out.println("Maximum Waiting Time: " + scheduler.findMaximumWaitingTime());
	        
	    
	    }
	}

