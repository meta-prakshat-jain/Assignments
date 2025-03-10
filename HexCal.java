package Assignment2;
import java.util.Scanner;

class HexCal {
    
	/**
     * Converts a  hexadecimal to decimal.
     * 1st converting string to upper case 
     * if character is between 0 to 9 then decreasing ascii value of 0
     * if character is between A to F then decreasing ascii value of A +10

     */
    public static int hexToDec(String hex) {
        try {
            hex = hex.toUpperCase();
            int decimal = 0;
            int power = 0;

            for (int i = hex.length() - 1; i >= 0; i--) {
                char currChar = hex.charAt(i);
                int digitValue;

                if (currChar >= '0' && currChar <= '9') {
                    digitValue = currChar - '0';
                } else if (currChar >= 'A' && currChar <= 'F') {
                    digitValue = currChar - 'A' + 10; 
                } else {
                    throw new IllegalArgumentException("Invalid hexadecimal character: " + currChar);
                }

                decimal += digitValue * Math.pow(16, power);
                power++;
            }
            return decimal;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return -1; 
        }
    }

    /**
     * Converts a decimal integer to a hexadecimal string.
     * Checkin if decimal is less then 0 
     * if yes throw error
     * if decimal==0 then return 0
     * Making an string builder to convert decimal to hexadecimal
     */
    public static String decimalToHex(int decimal) {
        if (decimal < 0) {
            return "Error: Negative numbers are not supported";
        }
        if (decimal == 0) {
            return "0";
        }

        StringBuilder hex = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 16;
            char hexChar = (char) ((remainder < 10) ? ('0' + remainder) : ('A' + (remainder - 10)));
            hex.append(hexChar);
            decimal /= 16;
        }
        return hex.reverse().toString();
    }
    /**
     * Helps to add two hexadecimal 
     * 1st:- We are converting hexadecimal to decimal both the strings
     * 2nd:-THen we are converting the whole answer into decimal to hexadecimal
     * @param hex1
     * @param hex2
     * @return adding 
     */
    public String add(String hex1, String hex2) {
        return decimalToHex(hexToDec(hex1) + hexToDec(hex2));
    }
    /**
     * Helps to Subtract two hexadecimal 
     * 1st:- We are converting hexadecimal to decimal both the strings
     * 2nd:-Ten we are converting the whole answer into decimal to hexadecimal
     * @param hex1
     * @param hex2
     * @return subtract
     * we are also checking if if answer is not getting negative 
     */
    public String subtract(String hex1, String hex2) {
        int dec1 = hexToDec(hex1);
        int dec2 = hexToDec(hex2);
        if (dec1 < dec2) {
            return "Error: Negative result not supported";
        }
        return decimalToHex(dec1 - dec2);
    }
    /**
     * Helps to Multiply two hexadecimal 
     * 1st:- We are converting hexadecimal to decimal both the strings
     * 2nd:-Then we are converting the whole answer into decimal to hexadecimal
     * @param hex1
     * @param hex2
     * @return Multiply 
     */

    public String multiply(String hex1, String hex2) {
        return decimalToHex(hexToDec(hex1) * hexToDec(hex2));
    }
    /**
     * Helps to divide two hexadecimal 
     * 1st:- We are converting hexadecimal to decimal both the strings
     * 2nd:-THen we are converting the whole answer into decimal to hexadecimal
     * @param hex1
     * @param hex2
     * @return divide 
     * we are also checking if if answer is not getting negative 
     */
    public String divide(String hex1, String hex2) {
        int dec1 = hexToDec(hex1);
        int dec2 = hexToDec(hex2);
        if (dec2 == 0) {
            return "Error: Division by zero is not allowed";
        }
        return decimalToHex(dec1 / dec2);
    }
/**
 * Checking if two hexadecimals are equal or not 
 * By converting them and checking if they are equal or not 
 * And returning true if equal
 * @param hex1
 * @param hex2
 * @return
 */
    public boolean equals(String hex1, String hex2) {
        return hexToDec(hex1) == hexToDec(hex2);
    }
    /**
     * Checking if two hexadecimals which is greater
     * By converting them and checking which is greater which is smaller
     * And returning true for greater one
     * @param hex1
     * @param hex2
     * @return Greater Hexa decimal
     */
    public boolean greaterThan(String hex1, String hex2) {
        return hexToDec(hex1) > hexToDec(hex2);
    }
    /**
     * Checking the smaller hexadecimals between these two
     * By converting them and checking which is smaller 
     * And returning smaller one
     * @param hex1
     * @param hex2
     * @return less hexadecimal
     */

    public boolean lessThan(String hex1, String hex2) {
        return hexToDec(hex1) < hexToDec(hex2);
    }

    public static void main(String[] args) {
        HexCal calc = new HexCal();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
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

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                String hex1, hex2, result;
                int decimal;
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
                        result = calc.divide(hex1, hex2);
                        System.out.println("Result: " + result);
                        break;

                    case 5:
                        System.out.print("Enter first hexadecimal number: ");
                        hex1 = scanner.nextLine();
                        System.out.print("Enter second hexadecimal number: ");
                        hex2 = scanner.nextLine();
                        comparisonResult = calc.equals(hex1, hex2);
                        System.out.println("Are they equal? " + comparisonResult);
                        break;

                    case 6:
                        System.out.print("Enter first hexadecimal number: ");
                        hex1 = scanner.nextLine();
                        System.out.print("Enter second hexadecimal number: ");
                        hex2 = scanner.nextLine();
                        comparisonResult = calc.greaterThan(hex1, hex2);
                        System.out.println("Is first greater than second? " + comparisonResult);
                        break;

                    case 7:
                        System.out.print("Enter first hexadecimal number: ");
                        hex1 = scanner.nextLine();
                        System.out.print("Enter second hexadecimal number: ");
                        hex2 = scanner.nextLine();
                        comparisonResult = calc.lessThan(hex1, hex2);
                        System.out.println("Is first less than second? " + comparisonResult);
                        break;

                    case 8:
                        System.out.print("Enter hexadecimal number: ");
                        hex1 = scanner.nextLine();
                        decimal = hexToDec(hex1);
                        if (decimal != -1) {
                            System.out.println("Decimal equivalent: " + decimal);
                        }
                        break;

                    case 9:
                        System.out.print("Enter decimal number: ");
                        decimal = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        result = decimalToHex(decimal);
                        System.out.println("Hexadecimal equivalent: " + result);
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter valid hexadecimal or decimal values.");
                scanner.nextLine(); 
            }
        }
    }
}
