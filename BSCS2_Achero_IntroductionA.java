package bscs2_Achero_IntroductionA;
import java.util.Scanner;
public class BSCS2_Achero_IntroductionA 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int input1;
		int option_number;
		
		
		System.out.print("Input Integer Value: ");
		input1 = scan.nextInt();
				
		System.out.print("\nOptions:" + "\n1 - Sum of digit" + "\n2 - Reverse the number" + "\n3 - Display all the prime number from 2 to n" + "\n4 - Palindrome Checking" +"\n5 - Odd or even number" + "\n6 - Exit");
		System.out.print("\n\nEnter option number: ");
		option_number = scan.nextInt();
		
		switch (option_number)
		{
			case 1:
				option1(input1);
				break;
			case 2:
				option2(input1);
				break;
			case 3:
				option3(input1);
				break;
			case 4:
				option4(input1);
				break;
			case 5:
				option5(input1);
				break;
			case 6:
				option6(input1);
				break;
			default:
				System.out.println("\nYou've entered a number that is not in the options!");
				break;
		}
	}
	
	static void option1(int input1)
	{
		System.out.println();
		int sum = 0;
		int rev = 0;
		
		for(int digit = 0; input1 !=0; input1 = input1/10)
		{
			digit = input1%10;
			rev = rev * 10 + digit;
			sum = sum + digit;
	
		}
		
		for(int digit = 0; rev!=0; rev = rev/10)
		{
			digit = rev%10; 
			
			if(rev/10 <=0)
			{
				System.out.print(digit + " = " + sum);
			}
			else
			{
				System.out.print(digit + " + ");
			}
		}			
	}
	
	static void option2(int input1)
	{
		System.out.println();
		System.out.println("Given:\t\t\t" + input1);
		System.out.print("\nReversed Number:\t");
		
		for(int rev = 0; input1 != 0; input1=input1/10)
		{
			rev = input1%10;
			System.out.print(rev);
		}
	}
	
	static void option3(int input1)
	{
		System.out.println();
		
		int[] arr;
		arr = new int [input1-1];
		
		for(int i = 0, num = 2;  num <= input1 ; i++, num++)
		{
			arr[i] = num;
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		for(int ctrl = 0, j = 0;  ctrl < input1-1; j++)
		{		
			if(arr[j] != 0)
			{
				for(int i = 0; i < input1-1; i++)
				{
					if(arr[i] == arr[j])
					{
						System.out.print(arr[i] + " ");
						ctrl++;
					}
					else if (arr[i] == 0)
					{
						ctrl++;
					}
					else if(arr[i]%arr[j] == 0)
					{
						arr[i] = 0;
					}
					else if (arr[i]%arr[j] != 0)
					{
						System.out.print(arr[i] + " ");
						ctrl++;
					}
				
				}	
				
				System.out.println();
					
				if(ctrl != input1-1)
				{
					ctrl = 0;

				}
				
				else if(ctrl == input1-1)
				{
					System.out.print("Last line above are the prime numbers under " + input1);
					System.exit(0);
				}
			}
			else
			{
				// Do nothing (skip)
			}
			
		}
		
	}	
		
	static void option4(int input1)
	{
		System.out.println();
		int given = input1;
		int rev = 0, rem;
		
		for(; input1 !=0; input1 = input1/10)
		{
			rem = input1 % 10;
			rev = rev * 10 + rem;
		}
		
		if(given == rev)
		{
			System.out.print(given + " is Palindrome");
		}
		else
		{
			System.out.print(given + " is not Palindrome");
		}
	}
	
	static void option5(int input1)
	{
		System.out.println();
		
		if(input1%2 == 0)
		{
			System.out.print(input1 + " is an Even number");
		}
		else
		{
			System.out.print(input1 + " is an Odd number");
		}
	}
	
	static void option6(int input1)
	{
		System.out.println("\nNoriel Achero | 1 BSCS 2");
		System.exit(0);
	}
}
