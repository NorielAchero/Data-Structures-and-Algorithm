package BSCS2_Achero_Binary;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BSCS2_Achero_Binary 
{

	static Scanner scan = new Scanner (System.in);
	static int size;
	static int [] arr;
	static int [] arrResult;
	static int value;
	static boolean ctrl = true;
	static boolean checker;
	
	public static void main(String[] args) 
	{
		header();
		
		while(ctrl == true)
		{	
			loading();
			initialize();
			loading();
			optionMenu();
			
			pr("\n\n\t\t     Do you want to try another search? " + "\n\t\t\t   [1 = Yes] [2 = No] ");
			int restart = scan.nextInt();
			
			if(restart == 1)
			{
				ctrl = true;
			}
			else if(restart == 2)
			{
				exit();
				ctrl = false;
				break;
			}
			prln("");
			
		}
		
	}
	
	public static void sequentialSearch()
	{
		boolean searching = false;
		prln("");
		
		loading();
		
		pr("\t\t     Enter value to search: ");
		value = scan.nextInt();
		
		prln("");
		
		for(int i = 0; i < arr.length; i++)
		{
			
			prln("\t\t           Searching Index " + i);
			loading();
			
			if(arr[i] == value)
			{
				prln("\n\t\t     Found the value " + value + " at the index " + i);
				searching = true;
			}
		}
		
		if(!searching)
		{
			prln("\n\t      Desired value of " + value + " does not exist in the list");
		}
	}
	
	public static void binarySearch()//I did not include  the "ceil" since the program automatically selects the rounded up index.
	{
		loading();
		pr("\n\t\t     Sorted List = ");
		sort();
		
		pr("\n\t\t     Enter value to search: ");
		value = scan.nextInt();
		
		int start = 0;
		int end = arr.length-1;
		double dCenter;
		int center;
		checker = false;
		int o = 0;
		
		while(start <= end)
		{
			loading();
			dCenter =  (start + end)/2;
			center = (int) dCenter;

			pr("\n\t\t     List = ");
			prArr(start, end+1);
			prln("");
			
			if(value < arr[center])
			{
				prln("\t\t     " +  value + " < " + arr[center]);
				end = center - 1;
			}
			else if(value > arr[center])
			{
				prln("\t\t     " + value + " > " + arr[center]);
				start = center + 1;
			}
			else if(value == arr[center])
			{
				prln("\t\t     " + value + " = " + arr[center]);
				prln("\n\t\t     Found the value " + value + " at the index " + center);
				
				prResult(value);
				
				checker = true;
				break;
			}
			prln("");
			arrResult[o] = arr[center];
			o++;
		}

		
		if(!checker)
		{
			loading();
			prln("\n\t\t     Desired value of " + value + " does not exist in the list");
			prResult(-100);
		}
	}
	
	public static void exit()
	{
		loading();
		prln("");
		prln("\t\t                      __");
		prln("\t\t               ___  _// \\");
		prln("\t\t             _/   \\/__|_ \\");		
		prln("\t\t            /  __//_/==\\_| ___");
		prln("\t\t          / | / /|// == \\ \\   /");
		prln("\t\t          |  | |\\|| //_\\ | |_/");
		prln("\t\t           \\  \\ \\\\ / \\_/| || \\");
		prln("\t\t            \\___/\\\\| _  ///___\\");
		prln("\t\t              \\__|\\_\\=//_// _\\_|");
		prln("\t\t                 \\___\\_____/");
		prln("\t\t                !! \\____/");
		prln("\t\t               !!");
		prln("\t\t                !!");
		prln("\t\t     ___      -(!!      __ ___ _");
		prln("\t\t     |\\|  \\       !!_.-~~ /|\\-  \\~-._");
		prln("\t\t     | -\\| |      !!/   /  | |\\- | |\\ \\");
		prln("\t\t     \\__-\\|______ !!  |    \\___\\|  \\_\\|");
		prln("\t\t     _____ _.-~/|\\     \\\\!!  \\  |  /       ~-.");
		prln("\t\t     /     /|  / /|  \\    \\!!    \\ /          |\\~-");
		prln("\t\t     /  ---/| | |   |\\  |     !!                 \\__|");
		prln("\t\t     | ---/| | |  \\ /|  /    -(!!");
		prln("\t\t     | -/| |  /     \\|/        !!");
		prln("\t\t     |/____ /                  !!)-");
		prln("\t\t                    !!");		
		prln("\n\n\t\t      Achero, Noriel R. | 1 BSCS 2");		
		System.exit(0);
	}
	
	public static void sort()
	{
		for(int j = 1; j < arr.length; j++)
		{
			for(int i = j; i > 0; i--)
			{
				if(arr[i] < arr[i-1])
				{
					int temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		prArr(0, arr.length);
	}
	
	
	public static void initialize()
	{	
		pr("\t\t     Enter number of elements in list: ");
		size = scan.nextInt();
		
		arr = new int[size];
		arrResult = new int[size];

		prln("");
		
		for(int i = 0; i < arr.length; i++)
		{
			pr("\t\t     Enter value for number " + (i+1) + ": ");
			arr[i] = scan.nextInt();
		}	
	}
	
	public static void optionMenu()
	{
		prln("\t\t\t\t  Menu\n");
		prln("\t\t     1. Sequencial Search");
		prln("\t\t     2. Binary Search");
		prln("\t\t     3. Exit\n");
		pr("\t\t     Enter Choice [1-3]: ");
		int choice = scan.nextInt();
		
		switch(choice)
		{
		case 1:
			sequentialSearch();
			
			break;
		case 2:
			binarySearch();
			break;
		case 3:
			exit();
			break;
		default:
			break;
		}
	}
	
	public static void prArr(int index, int length)
	{
		for(int i = index ; i < length; i++)
		{
			pr(arr[i] + " ");
		}
	}
	
	public static void prResult(int value)
	{
		prln("");
		pr("\t\t     Comparison List: ");
		for(int i = 0 ; i < arrResult.length; i++)
		{
			if(arrResult[i] != 0)
			{
				pr(arrResult[i] + " ");
			}
			else
			{
				break;
			}
		}
		
		if(value > -1)
		{
			pr("" + value);
		}
	}
	
	public static void arrReset()
	{
		for(int i = 0 ; i < arrResult.length; i++)
		{
			arrResult[i] = 0;
		}
	}
	
	public static void pr(String pr)
	{
		System.out.print(pr);
	}
	
	public static void prln(String pr)
	{
		System.out.println(pr);
	}
	
	public static void loading()
	{
		try 
		{
			prln("\n\t\t\t\tLoading");
			pr("\t\t     |");
			printWithDelays("----------------------------", TimeUnit.MILLISECONDS, 100);
			pr("|");
			prln("\n");
			
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
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
	
	public static void header()
	{
		prln("      ________  _______   ________  ________  ________  ___  ___     ");
		prln("     |\\   ____\\|\\  ___ \\ |\\   __  \\|\\   __  \\|\\   ____\\|\\  \\|\\  \\    ");
		prln("     \\ \\  \\___|\\ \\   __/|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\___|\\ \\  \\\\\\  \\   ");
		prln("      \\ \\_____  \\ \\  \\_|/_\\ \\   _  _\\ \\   __  \\ \\  \\    \\ \\   __  \\  ");
		prln("       \\|____|\\  \\ \\  \\_|\\ \\ \\  \\\\  \\\\ \\  \\ \\  \\ \\  \\____\\ \\  \\ \\  \\ ");
		prln("         ____\\_\\  \\ \\_______\\ \\__\\\\ _\\\\ \\__\\ \\__\\ \\_______\\ \\__\\ \\__\\");
		prln("        |\\_________\\|_______|\\|__|\\|__|\\|__|\\|__|\\|_______|\\|__|\\|__|");
		prln("        \\|_________|                                                 ");
	}

}
