package Assignment2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 class HexCal{
	 /**
	  * THis Method is converting our hexadecimal string to decimal
	  * @param hex
	  * @return decimal
	  */
	public static int HexToDec(String hex) {
		hex=hex.toUpperCase();
		int decimal=0;
		int power=0;
		for(int i=hex.length()-1;i>=0;i--) {
			char currChar=hex.charAt(i);
			int digitValue;
			if(currChar>='0' && currChar<='9') {
				digitValue=currChar-'0';
			}else if(currChar>='A' && currChar<='F') {
				digitValue=currChar-'A'+10;//Convert char A-F to integer
			}else {
				throw new IllegalArgumentException("Invalid hexadecimal character: "+currChar);
			}
			decimal+=digitValue*Math.pow(16, power);
			power++;
		}
		return decimal;
	}
	
	public static String decimalToHex(int decimal) {
		if(decimal==0) {
			return  "0";			
		}
		StringBuilder hex=new StringBuilder();
		while(decimal>0) {
			int remainder=decimal%16;
			char hexChar;
			if(remainder<10) {
				hexChar=(char)('0'+remainder);//Convert 0-9 to character 0-9
			}else {
				hexChar=(char)('A'+(remainder-10));//Convert 10-15 to A-F
			}
			hex.append(hexChar);
			decimal/=16;
		}
		return hex.reverse().toString();
	}
	
		public String add(String hex1,String hex2) {
			return decimalToHex(HexToDec(hex1)+HexToDec(hex2));
		}
		public String subtract(String hex1,String hex2) {
			int dec1=HexToDec(hex1);
			int dec2=HexToDec(hex2);
			if(dec2>dec1) {
				return"Error: Negative Result not supported";
			}
			return decimalToHex(dec1-dec2);
		}
		public String multiply(String hex1,String hex2) {
			return decimalToHex(HexToDec(hex1)*HexToDec(hex2));
		}
		public String Divide(String hex1,String hex2) {
			int dec1=HexToDec(hex1);
			int dec2=HexToDec(hex2);
			if(dec2>dec1) {
				return"Error: Divison by Zero";
			}
			return decimalToHex(dec1/dec2);
		}
	public boolean equals(String hex1,String hex2) {
		hex1=hex1.toUpperCase();
		hex2=hex2.toUpperCase();
		return hex1.equals(hex2);
	}
	public boolean greaterThan(String hex1,String hex2) {
		hex1=hex1.toUpperCase();
		hex2=hex2.toUpperCase();
		int len1=hex1.length();
		int len2=hex2.length();
		if(len1>len2) {
			return true;
		}else if(len2>len1) {
			return false;
		}
		for(int i=0;i<len1;i++) {
			char char1=hex1.charAt(i);
			char char2=hex2.charAt(i);
			
			if(char1>char2) {
				return true;
			}else if(char2>char1) {
				return false;
			}
		}
		return false;
	}
	public boolean lessThan(String hex1,String hex2) {
		hex1=hex1.toUpperCase();
		hex2=hex2.toUpperCase();
		int len1=hex1.length();
		int len2=hex2.length();
		if(len1<len2) {
			return true;
		}else if(len2<len1) {
			return false;
		}
		for(int i=0;i<len1;i++) {
			char char1=hex1.charAt(i);
			char char2=hex2.charAt(i);
			
			if(char1<char2) {
				return true;
			}else if(char2<char1) {
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
//		String hexNumber="1A3";
//		int decimalEquivalent=HexToDec(hexNumber);
//		System.out.println("Hexadecimal "+hexNumber+" = Decimal "+decimalEquivalent);
//		int decimalNumber=419;
//		String hex=decimalToHex(decimalNumber);
//		System.out.println("Decimal "+decimalNumber+" = Hexadecimal "+hex);
		 HexCal calc = new HexCal();
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	            System.out.println("\nHexadecimal Calculator Menu:");
	            System.out.println("1. Add");
	            System.out.println("2. Subtract");
	            System.out.println("3. Multiply");
	            System.out.println("4. Divide");
	            System.out.println("5. Equals");
	            System.out.println("6. Greater Than");
	            System.out.println("7. Less Than");
	            System.out.println("8. Hex to Decimal");
	            System.out.println("9. Decimal to Hex");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");

	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            String hex1, hex2, result;
	            int decimal, resultDecimal;
	            boolean comparisonResult;

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter first hexadecimal number: ");
	                    hex1 = scanner.nextLine();
	                    System.out.print("Enter second hexadecimal number: ");
	                    hex2 = scanner.nextLine();
	                    result = calc.add(hex1, hex2);
	                    System.out.println("Result: " + result);
	                    break;
	                case 2:
	                    System.out.print("Enter first hexadecimal number: ");
	                    hex1 = scanner.nextLine();
	                    System.out.print("Enter second hexadecimal number: ");
	                    hex2 = scanner.nextLine();
	                    result = calc.subtract(hex1, hex2);
	                    System.out.println("Result: " + result);
	                    break;
	                case 3:
	                    System.out.print("Enter first hexadecimal number: ");
	                    hex1 = scanner.nextLine();
	                    System.out.print("Enter second hexadecimal number: ");
	                    hex2 = scanner.nextLine();
	                    result = calc.multiply(hex1, hex2);
	                    System.out.println("Result: " + result);
	                    break;
	                case 4:
	                    System.out.print("Enter first hexadecimal number: ");
	                    hex1 = scanner.nextLine();
	                    System.out.print("Enter second hexadecimal number: ");
	                    hex2 = scanner.nextLine();
	                    result = calc.Divide(hex1, hex2);
	                    System.out.println("Result: " + result);
	                    break;
	                case 5:
	                    System.out.print("Enter first hexadecimal number: ");
	                    hex1 = scanner.nextLine();
	                    System.out.print("Enter second hexadecimal number: ");
	                    hex2 = scanner.nextLine();
	                    comparisonResult = calc.equals(hex1, hex2);
	                    System.out.println("Result: " + comparisonResult);
	                    break;
	                case 6:
	                    System.out.print("Enter first hexadecimal number: ");
	                    hex1 = scanner.nextLine();
	                    System.out.print("Enter second hexadecimal number: ");
	                    hex2 = scanner.nextLine();
	                    comparisonResult = calc.greaterThan(hex1, hex2);
	                    System.out.println("Result: " + comparisonResult);
	                    break;
	                case 7:
	                    System.out.print("Enter first hexadecimal number: ");
	                    hex1 = scanner.nextLine();
	                    System.out.print("Enter second hexadecimal number: ");
	                    hex2 = scanner.nextLine();
	                    comparisonResult = calc.lessThan(hex1, hex2);
	                    System.out.println("Result: " + comparisonResult);
	                    break;
	                case 8:
	                    System.out.print("Enter hexadecimal number: ");
	                    hex1 = scanner.nextLine();
	                    decimal = calc.HexToDec(hex1);
	                    System.out.println("Result: " + decimal);
	                    break;
	                case 9:
	                    System.out.print("Enter decimal number: ");
	                    decimal = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    result = calc.decimalToHex(decimal);
	                    System.out.println("Result: " + result);
	                    break;
	                case 0:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	    }
	}