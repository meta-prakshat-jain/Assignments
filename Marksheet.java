package Assignment3;
import java.util.*;
/**
 * This Class is used to calculate the different operations we do on marksheet having n students
 */
public class Marksheet { 
	 private int n;//Number Of Students 
	 private double[] grades; //Grades of n number if students 
	 /**
	  * The constructor is used to intialize our objects
	  * which helps prevent errors and improve code quality
	  * @param grades
	  */
	 public Marksheet(double[] grades) { 
	  if (grades == null || grades.length == 0) { 
	            throw new IllegalArgumentException("Grades array must not be empty."); 
	        } 
	        this.n=grades.length; 
	        this.grades=grades; 
	 } 
	 /**
	  * Calculating the average grades of the students 
	  * @return average grades
	  * @throws ArithmeticException
	  */
	 public double AverageGrades()throws ArithmeticException { 
	    if (grades.length == 0) { 
	              throw new ArithmeticException("Cannot calculate average with no students."); 
	          } 
	    for(int i=0;i<grades.length;i++) {
	    	if(grades[i]<0) {
	    		throw new  ArithmeticException();
	    	}
	    }
	  int total=0; 
	  for(double grade:grades) {//0-4 
	   total+=grade; 
	  } 
	 
	  return(double)total/n; 
	   
	 } 
	 /**
	  * This method is calculating the maximum of all grades
	  * from our grades array
	  * @return maximum 
	  */
	public double MaximumOfAllGrades() { 
		if (grades.length == 0) { 
	        throw new ArithmeticException("Cannot calculate average with no students."); 
	    } 
		double max=0; 
		for(double grade:grades) { 
			  if(grade>max) { 
			   max=grade; 
		  } 
		 } 
		 return max;  
		} 
	/**
	 * This method is calculating the minimum of all grades
	 * @return minimum
	 */
		public double MinimumOfAllGrade() { 
		 if (grades.length == 0) { 
		        throw new ArithmeticException("Cannot calculate average with no students."); 
		    } 
		 double min=9999; 
		 for(double grade:grades) { 
		  min=Math.min(min, grade); 
		 } 
		 return min;  
		} 
		/**
		 * THis method is returning the number of students passed
		 * @return percentage of students passed
		 */
		public double percentageOfStudentsPassed()  { 
		 if (grades.length == 0) { 
		        throw new ArithmeticException("Cannot calculate average with no students."); 
		    } 
		 
		 int countNumOfPassedStudents=0; 
		 for(double grade:grades) { 
		  if(grade>40) { 
		   countNumOfPassedStudents++; 
		  } 
		 } 
		 
		 double ans=((double)countNumOfPassedStudents/n);//ensures floating-point division 
		 System.out.println("Percentage:-"); 
		 return (double)ans*100; 
		} 
		 
		 
		    
		public static void main(String[] args) { 
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Choose Number of Students");
			int n=sc.nextInt();
			System.out.println("Enter the Grades");
			double [] arr=new double [n];
			boolean flag=true;
			try {
				for(int i=0;i<arr.length;i++) {
					System.out.println("Enter the grades of students"+i);
					int mark=sc.nextInt();
					if(mark < 0 || mark > 100) {
						throw new ArithmeticException("Range between 0 to 100.");
					}
					arr[i] = mark;
				}
			}catch(ArithmeticException e) {
				System.out.println(e.getMessage());
			}
				
				while(flag) {
				System.out.println("Marksheet");
				System.out.println("\nEnter 1:-Return Average of all grades");
				System.out.println("Enter 2:-Retrun maximum of all grades");
				System.out.println("Enter 3:-Return Minimum of allgrades");
				System.out.println("Enter 4:-Return percentage of students passed");
				
			
			
			Marksheet mk=new Marksheet(arr);
			int choose=sc.nextInt();
			sc.nextLine();
			/**
			 * We are using the switch cases to provide a menu based system to our user 
			 * to calculate the are of different shapes
			 */
			switch(choose) {
			case 1:
				System.out.println("Average Grades:-");
				System.out.println(mk.AverageGrades());
				break;
			case 2:
				System.out.println("Maximum of all grades:-");
				System.out.println(mk.MaximumOfAllGrades());
				break;
			case 3:
				System.out.println("Minimum of all grades");
				System.out.println(mk.MinimumOfAllGrade());
				break;
			case 4:
				System.out.println("Percentage of students passed");
				System.out.println(mk.percentageOfStudentsPassed());
				break;
			default:
				System.out.println("Invalid User Input");
				flag=false;
			}
		  
		

		}
		}
}
		 
