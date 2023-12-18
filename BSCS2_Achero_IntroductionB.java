package bscs2_Achero_IntroductionB;
import java.util.Scanner;

public class BSCS2_Achero_IntroductionB 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		String input1 = "";
		String input2 = "";
		int option_number;
		
		System.out.print("Enter String 1: ");
		input1 = scan.next();
		
		System.out.print("Enter String 2: ");
		input2 = scan.next();
		
		System.out.print("\nOptions:" + "\n1 - String copy" + "\n2 - String concatenation" + "\n3 - String Comparison" + "\n4 - Reverse the first string input" +"\n5 - Convert the first string into (Uppercase to Lowercase & Lowercase to Uppercase)" + "\n6 - Toggle the first string" + "\n7 - Exit");
		System.out.print("\n\nEnter option number: ");
		option_number = scan.nextInt();
		
		switch (option_number)
		{
			case 1:
				option1(input1, input2);
				break;
			case 2:
				option2(input1, input2);
				break;
			case 3:
				option3(input1, input2);
				break;
			case 4:
				option4(input1, input2);
				break;
			case 5:
				option5(input1, input2);
				break;
			case 6:
				option6(input1, input2);
				break;
			case 7:
				option7(input1, input2);
				break;
			default:
				System.out.println("\nYou've entered a number that is not in the options!");
				break;
		}		
		
	}
	
	static void option1(String input1, String input2)
	{
		Scanner scan2 = new Scanner(System.in);
		String str3 = "";
		int strcopy;
		
		System.out.print("Input number of string to copy (1 or 2): ");
		strcopy = scan2.nextInt();
		
		System.out.println();
		switch (strcopy)
		{
			case 1:
				str3 = input1;
				System.out.println("The copied value of String 3 from String 1 is " + str3.replaceAll(input1, str3));
				break;
			case 2:
				str3 = input2;
				System.out.println("The copied value of String 3 from String 2 is " +str3.replaceAll(input2, str3));
				break;
			default:
				System.out.println("You've entered a number that is not in the options!");
		}	
	}
	
	static void option2(String input1, String input2)
	{
		System.out.println();
		String con = input1.concat(input2);
		System.out.println("Concatinated Strings 1 and 2: "  +con);
		
	}
	
	static void option3(String input1, String input2)
	{
		System.out.println();
		
		if(input1.equals(input2))
		{
			System.out.println("String 1 and String 2 are the same.");
		}
		else if(input1.equalsIgnoreCase(input2) == true)
		{
			System.out.println("String 1 and String 2 are similar but has a difference in casing.");
		}
		else
		{
			System.out.println("String 1 and String 2 are absolutely not the same.");
		}
	}
	
	static void option4(String input1, String input2)
	{
		System.out.println();
		String rev = "";
		char j = 'A';
		
		
		for(int i = input1.length() - 1; i >= 0; i--)
		 {
				j = input1.charAt(i);
				rev = rev + j;
		 }
		 System.out.println("Reversed String 1: " + rev);
		 
		 
	}
	
	static void option5(String input1, String input2)
	{
		System.out.println();
		System.out.println("Uppercased: " + input1.toUpperCase());
		System.out.println("Lowercased: " + input1.toLowerCase());
	}
	
	static void option6(String input1, String input2)
	{
		System.out.println();
		String toggle= "";
		char j = 'A';
		
		for(int i = 0; i < input1.length(); i++)
		 {
			if(input1.charAt(i)>='A' && input1.charAt(i)<='Z')
			{
				j = input1.charAt(i);
				j = Character.toLowerCase(j);
				toggle = toggle + j;
			}
			else if(input1.charAt(i)>='a' && input1.charAt(i)<='z')
			{
				j = input1.charAt(i);
				j = Character.toUpperCase(j);
				toggle = toggle + j;
			}
		 }
		 System.out.println("Toggled String 1: " + toggle);
		
		
	}
	
	static void option7(String input1, String input2)
	{
		System.out.println("\nNoriel Achero | 1 BSCS 2");
		System.exit(0);
	}

}
