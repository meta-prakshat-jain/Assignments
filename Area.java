package Assignment3;

import java.util.Scanner;
/**
 * This class area is used to calculate the area of different shapes
 * And also handling the arthimetic exception if user is entering the wrong input
 * 
 */

public class Area { 
	/**
	 * With the help of this method we are returning the area of triangle
	 * @param width
	 * @param height
	 * @return Area of triangle 
	 * @throws ArithmeticException
	 */
	static double AreaOfTriangle(double width,double height)throws ArithmeticException { 
		
	 if(height <=0||width <= 0) { 
		 throw new ArithmeticException("Width and height must be greater than zero!"); 
	 } 
	 return  width*height*0.5; 
	 } 
	/**
	 * This Method is returning the area of rectangle
	 * @param width
	 * @param height
	 * @return Area of rectangle
	 * @throws ArithmeticException
	 */
	static double AreaOfRectangle(double width,double height)throws ArithmeticException { 
		if(height <= 0||width <= 0) { 
			throw new ArithmeticException("Width and height must be greater than zero!"); 
	 } 
	 return  width*height; 
	 } 
	/**
	 * With the help of this method we are returning the area of square
	 * @param width
	 * @return area of square
	 * @throws ArithmeticException
	 */
	static double AreaOfSquare(double width)throws ArithmeticException { 
		if(width <= 0) { 
			throw new ArithmeticException("Width must be greater than zero!"); 
	 } 
	 return width*width; 
	 } 
	/**
	 * This method return area of circle
	 * @param radius
	 * @return area of circle
	 * @throws ArithmeticException
	 */
	static double AreaOfCircle(double radius)throws ArithmeticException { 
	 if(radius <= 0) { 
		 throw new ArithmeticException("Radius must be greater than zero!"); 
	 } 
	 return (Math.PI)*(radius*radius) ; 
	 } 
	
	public static void main(String[] args) { 
		Scanner sc=new Scanner(System.in);
		Area areaOfShapes=new Area(); 
		System.out.println("Area of Shapes");
		System.out.println("\nEnter 1:-Triangle");
		System.out.println("Enter 2:-Rectangle");
		System.out.println("Enter 3:-Square");
		System.out.println("Enter 4:-Circle");
		int choose=sc.nextInt();
		sc.nextLine();
		switch(choose) {
		/**
		 * We are using the switch cases to provide a menu based system to our user 
		 * to calculate the are of different shapes
		 */
		case 1:
			System.out.println(" Enter The width:- ");
			double width=sc.nextDouble();
			System.out.println(" Enter The height:- ");
			double heignt=sc.nextDouble();
			try {
				System.out.println(areaOfShapes.AreaOfTriangle(width,heignt)); 
			}catch(ArithmeticException e){
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			System.out.println(" Enter The width:- ");
			double width1=sc.nextDouble();
			System.out.println(" Enter The height:- ");
			double heignt1=sc.nextDouble();
			try{
				 System.out.println(areaOfShapes.AreaOfRectangle(width1,heignt1)); 			 
			}catch(ArithmeticException e){
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			System.out.println(" Enter The side of square:- ");
			double side=sc.nextDouble();
			
			try {
				System.out.println(areaOfShapes.AreaOfSquare(side)); 
			}catch(ArithmeticException e){
				System.out.println(e.getMessage());
			}
		
			break;
		case 4:
			System.out.println("Enter the radius");
			double radius=sc.nextDouble();
			try {
				System.out.println(areaOfShapes.AreaOfCircle(radius)); 
			}catch(ArithmeticException e){
				System.out.println(e.getMessage());
			}
			
		}
}
}
