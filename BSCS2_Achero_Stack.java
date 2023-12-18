
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BSCS2_Achero_Stack 
{
	public static Scanner scan = new Scanner(System.in);
	public static Object [] arr; 
	public static int input1 = 0;
	

	public static void main(String[] args)
	{

		int option;
		boolean ctrl1 = false;
		boolean ctrl2 = false;
	
		while(!ctrl1)
		{
			try
			{
				stackDesign();
				
				System.out.print("\nEnter number of elements in stack: ");
				input1 = scan.nextInt();
				arr = new Object[input1];
				
				
				printWithDelays("\n!------------CREATING STACK------------!", TimeUnit.MILLISECONDS, 100);
				
				System.out.println("\n\nYour stack has been created successfully!");
		
				
				while(!ctrl2)
				{
					try
					{
						System.out.println();
						
						System.out.println("MENU");
						System.out.println("1. PUSH"
											+ "\n2. POP "
											+ "\n3. TOP "
											+ "\n4. SIZE "
											+ "\n5. EMPTY "
											+ "\n6. DISPLAY STACK "
											+ "\n7. EXIT ");
						System.out.print("\nENTER OPTION: ");
						option = scan.nextInt();
						
						switch(option)
						{
							case 1:	
								nraPush();
								break;
							case 2:	
								nraPop();					
								break;
							case 3:	
								nraTop();				
								break;
							case 4:
								nraSize();		
								break;					
							case 5:
								nraEmpty();					
								break;
							case 6:
								nraDisplay();
								break;
							case 7:
								System.out.println("\n      Thank you for using");
								stackDesign();
								System.exit(0);
								ctrl2 = true;
								break;
							default:
								System.out.println("You've input a number that is not in the options!");
								break;
						}
				}
				catch(Exception b)
				{
					System.out.println("\nYou've input that is not in the options!");
					scan.next();
				}
			}
			}
			catch(Exception a)
			{
				System.out.println("\nYou've input a non-integer value.\n");
				scan.next();
			}
		}
	}
	
	
		
	
	public static void nraPush()
	{
		int push = 0;
		boolean ctrl = false;
		
		while(!ctrl)
		{
			try
			{
			System.out.print("\nEnter a number to push: ");
			push = scan.nextInt();

			printWithDelays("\n!------------PUSHING NUMBER " + push + "------------!" , TimeUnit.MILLISECONDS, 100);
			
			if(arr[arr.length-1] == null)
			{
				for(int i = 0; i < arr.length; i++)
				{
					if(arr[i] == null)
					{
						arr[i] = push;
						break;
					}
					else
					{
						//Do nothing
					}
					
				}
				
				System.out.println("\n\nSuccessfully pushed " + push);
			}
			else
			{
				System.out.print("\nSorry! The stack overflowed.\n");
			}
			break;
			}
			catch(Exception e)
			{
				System.out.println("\nYou've Entered a non-integer value.");
                scan.next();

			}
		}
		
		

	}
	
	public static void nraPop()
	{
	
	try
	{
		printWithDelays("\n!------------POPPING------------!" , TimeUnit.MILLISECONDS, 100);	
		for(int i = input1-1; i > 0; i--)
		{
			if(arr[0] == null)
			{
				System.out.println("\n\nThe Stack was empty. You cannot do the Pop Command.");
				break;
			}
			else if(arr[i] == null)
			{
				//do nothing
			}	
			else
			{
				System.out.print("\n\nSuccessfully pooped " + arr[i] + "\n");
				arr[i] = null;
				break;
			}
		}
	}
	
	catch(Exception a)
	{
		//Do Nothing
	}
	}
		
	
	public static void nraTop()
	{
	try
	{
		printWithDelays("\n!------------LOOKING FOR TOP------------!\n" , TimeUnit.MILLISECONDS, 100);	
		
		for(int i = input1-1; i >= 0; i--)
		{
			if(arr[0] == null)
			{
				System.out.println("\nThe stack is empty. Therefore, there is no top value.");
				break;
			}
			else if(arr[i] == null)
			{
				//do nothing
			}	
			else if (arr[i] != null)
			{
				System.out.println("\nThe top value of the stack is " + arr[i]);
				break;
			}
		}
		
	}
	catch(Exception e)
	{
		//Do Nothing
	}
	}
	
	public static void nraSize()
	{
		
	try
	{
		printWithDelays("\n!------------LOOKING FOR SIZE------------!\n" , TimeUnit.MILLISECONDS, 100);		
		int counter = 0;
		System.out.print("\nThe size of the stack is ");
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] != null)
			{
				counter++;
			}
			else
			{
				break;
			}
				
		}
		
		System.out.print(counter + "\n");
		
	}
	catch(Exception a)
	{
		//Do Nothing
	}
	}
	
	public static void nraEmpty()
	{
		try
		{
			printWithDelays("\n!------------IDENTIFYING STACK------------!\n" , TimeUnit.MILLISECONDS, 100);			
		
		boolean empty;
		
		if(arr[0] == null)
		{
			empty = true;
			System.out.println("\nYes, the stack is empty.");
		}
		else
		{
			empty = false;
			System.out.println("\nNo, the stack is not empty.");
		}
		
		}
		
		catch(Exception a)
		{
			//Do Nothing
		}

	}
	
	public static void nraDisplay()
	{
		
	try
	{
		printWithDelays("\n!------------DISPLAYING STACK------------!\n" , TimeUnit.MILLISECONDS, 100);		
		System.out.print("\nThe values of the stack are ");
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == null)
			{
				//do nothing
			}
			else
			{
				System.out.print(arr[i] + " ");
			}
		}
		
		System.out.println();
	}
	catch(Exception a)
	{
		//Do nothing
	}
		
	}
	
	public static void stackDesign()
	{
		System.out.println(" ____ ____ ____ ____ ____ ____ ");
		System.out.println("||S |||T |||A |||C |||K |||S ||");
		System.out.println("||__|||__|||__|||__|||__|||__||");
		System.out.println("|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|");
		System.out.println("\n  By Noriel Achero | 1 BSCS 2");
	}

	public static void printWithDelays(String data, TimeUnit unit, long delay)
	throws InterruptedException 
	{	
	    for (char ch:data.toCharArray()) 
	    {	
	        System.out.print(ch);
	        unit.sleep(delay);
	    }
	}
}
