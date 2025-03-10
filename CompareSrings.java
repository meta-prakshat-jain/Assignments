package Assignment3;

import java.util.Scanner;

public class CompareStrings {
	/**
	 *We made a function which is returning the length of our string
	 * @param s
	 * @return length
	 */
	static int GetLength(String s) { 
		  int i=0; 
		  try { 
		   while(true) { 
		    s.charAt(i); 
		    i++; 
		   } 
		    
		  } catch (IndexOutOfBoundsException e) { 
		   return i; 
		  } 
		   
		 } 
	/**
	 * We are comparing 2 strings returning 1 if equal 
	 * and returning 2 if unequal
	 * @param str1
	 * @param str2
	 * @return comparison
	 */
	static int compareTwoStrings(String str1,String str2) { 
		  if(GetLength(str1)!=GetLength(str2)) { 
		   return 0; 
		  } 
		  for(int i=0;i<GetLength(str1);i++) { 
		   if(str1.charAt(i)!=str2.charAt(i)) {
			   return 0; 
		   } 
		  } 
		  return 1; 
		 }
		   
//Reversing The String Method  
	/**
	 * returning he reverse of String
	 * @param string
	 * @return reverse of string
	 */
	public static String reverse(String s) { 
		String ansString=""; 
		for(int i=GetLength(s)-1;i>=0;i--) { 
			ansString+=s.charAt(i); 
		} 
		return ansString; 
	} 

	//Upper Case To Lower Case 
	/**
	 * Converting our lowercase to upper case 
	 * and upper case to lower case
	 * @param str
	 * @return
	 */
	public static String UpperToLower_LowerToUpper(String str) {  
		String result=""; 
		for(int i=0;i<GetLength(str);i++) { 
			char ch=str.charAt(i); 
		  
			int asciiValueOfCharacter=(int)ch; 
			if(asciiValueOfCharacter>=65&&asciiValueOfCharacter<=90) { 
				char ch2=(char)(asciiValueOfCharacter+32); 
				result+=ch2; 
			}else if (asciiValueOfCharacter >= 97 && asciiValueOfCharacter <= 122) { 
		         char ch2 = (char) (asciiValueOfCharacter - 32); 
		         result += ch2; 
		    }  else { 
		    	 result+=ch; 
		   } 
		} 
	return result; 
	} 

	//Longest WOrd 
	/**
	 * GIving the count of our array
	 * @param str
	 * @return
	 */
	public static int count(String str) { 
		int count=0; 
		for(int i=0;i<GetLength(str);i++) { 
			count++; 
		} 
		return count; 
		} 
	//Finding The last word of the String  
	/** 
	 * Givin the last word if 2 strings length are equal
	 * @param s
	 * @return lastWord
	 */

	public static String lastWord(String s) { 
		if (s == null || s.isEmpty()) return ""; 
		int i=GetLength(s)-1; 
		
		   while (i >= 0 && s.charAt(i) == ' ') { 
		       i--; 
		   } 
		   
		   // If the string is all spaces, return an empty string 
		   if (i < 0) return ""; 
		   String LastWOrd=""; 
		 
		while(s.charAt(i)!=' ') { 
			LastWOrd=s.charAt(i)+LastWOrd; 
			i--; 
		} 
		return LastWOrd; 
	 
	} 
	//Finding the Largest Word in the string 
	/**
	 * Comparing a sentance and finding the biggest word in string
	 * @param str
	 * @return largest word
	 */
	public static String LargestWordInString(String str){ 
		if (str == null || str.isEmpty()) { 
	           return ""; 
	       } 
		String longestWord=""; 
		String CurrentWord=""; 
		int maxLength=0; 
		boolean flag=false;//For the word having equal Lengths 
		for(int i=0;i<GetLength(str);i++) { 
			if(str.charAt(i)!=' ') { 
				CurrentWord+=str.charAt(i);  
		 } 
		 else { 
			 if(GetLength(CurrentWord)>maxLength) { 
				 maxLength=GetLength(CurrentWord); 
				 longestWord=CurrentWord; 
				 flag=false; 
		  }else if(GetLength(CurrentWord)==maxLength) { 
			  	 flag=true; 
		    
		  } 
		  CurrentWord=""; 
		 } 
		} 
		if(GetLength(CurrentWord)>maxLength) { 
			longestWord=CurrentWord; 
			flag=false; 
		}else if(GetLength(CurrentWord)==maxLength) { 
			flag=true; 
		} 
		if(flag) { 
		 return lastWord(str); 
		} 
		else { 
		return longestWord; 
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Perform Operation on Strings");
		System.out.println("\nEnter 1:-Compare Two Strings");
		System.out.println("Enter 2:-Retrun Reverse of String");
		System.out.println("Enter 3:-Upper TO lower Lower To Upper");
		System.out.println("Enter 4:-Return Largest word of the String");
		int choose=sc.nextInt();
		sc.nextLine();
		/**
		 * We are using the switch cases to provide a menu based system to our user 
		 * to calculate the are of different shapes
		 */
		switch(choose) {
		case 1:
			System.out.println("Enter The String 1:-");
			String str1=sc.nextLine();
//			sc.nextLine();
			
			System.out.println("Enter The String 2:-");
			String str2=sc.nextLine();
			System.out.println(compareTwoStrings(str1, str2));
			break;
		case 2:
			System.out.println("Enter the String You Want to Reverse:-");
			String str3=sc.nextLine();
			System.out.println(reverse(str3));
			break;
		case 3:
			System.out.println("Enter The String:-");
			String str4=sc.nextLine();
			System.out.println(UpperToLower_LowerToUpper(str4));
			break;
		case 4:
			System.out.println("Enter A String:-");
			String str5=sc.nextLine();
			System.out.println(LargestWordInString(str5));
			break;
		default:
			System.out.println("Invalid User Input");
		}
		}
	}

