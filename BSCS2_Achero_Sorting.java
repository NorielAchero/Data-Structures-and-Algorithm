package BSCS2_Achero_Sorting;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BSCS2_Achero_Sorting//Noriel Achero | 1 BSCS 2
{
	static Scanner scan = new Scanner (System.in);
	static int size;
	static int [] arr;
	static int temp;
	static String space;
	static boolean ctrl = true;
	
	
	public static void main(String[] args)
	{
		header();
		while(ctrl == true)
		{		
			loading();
			initialize();
			loading();
			optionMenu();
			
			pr("\n\n\t\t     Do you want to try another sorting? " + "\n\t\t\t   [1 = Yes] [2 = No] ");
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
	
	
	public static void bubble()//I used my own algorithm to create my methods >_<
	{
		boolean bCtrl = true;
		int pass = 1;
		
		while(bCtrl == true)
		{
			loading();
			prln("\n\n\t\t     Pass " + pass + "\n");
			prArr();
			
			for(int i = 1; i < arr.length; i++)
			{
				if(arr[i] < arr[i-1])
				{
					temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
				}		
				prln("");
				prArr();	
			}			
			validator();
			if(valid == arr.length-1)
			{
				bCtrl = false;
			}
			pass++;
		}		
		loading();
		pr("\n\n\t\t     Sorted Array \n");
		prArr();
	}
	
	public static void insertion()//I used my own algorithm to create my methods >_<
	{
		loading();		
		prln("\n");
		prArr();
		
		for(int j = 1; j < arr.length; j++)
		{
			for(int i = j; i > 0; i--)
			{
				if(arr[i] < arr[i-1])
				{
					temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
				}
			}
			prln("");
			prArr();
		}		
		loading();
		pr("\n\n\t\t     Sorted Array \n");
		prArr();
	}
	
	static int iDex;
	
	public static void selection()//I used my own algorithm to create my methods >_<
	{
	loading();	
	prln("\n");
	prArr();
	prln("");
		
	for(iDex = 0; iDex < arr.length-1; iDex++)
	{
		minFinder();
			if(arr[iDex] > arr[minIndex])
			{
				temp = arr[iDex];
				arr[iDex] = arr[minIndex];
				arr[minIndex] = temp;
			}
		prArr();
		prln("");
	}
	
	loading();
	pr("\n\n\t\t     Sorted Array \n");
	prArr();	
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
	
	static int minIndex = 0;
	public static void minFinder()
	{	
		for(int i = iDex + 1, ctrl = 0, counter = 0; i < arr.length; i++, counter = 0)
		{
			for(int j = i; j < arr.length; j++, counter++)
			{
				if(i != j)
				{
					if (arr[i] <= arr[j])
					{
						ctrl++;
					}
				}
				
			}
			if(ctrl != counter - 1)
			{
			ctrl = 0;
			}
			else
			{
			minIndex = i;
			break;
			}
		}
	}
	
	static int valid;
	
	public static void validator()
	{
		valid = 0;
		
		for(int i = 0; i < (arr.length-1); i++)
		{
			if(arr[i] <= arr[i+1])
			{
				valid++;
			}
		}	
	}

	
	public static void initialize()
	{	
		pr("\n\n\t\t     Enter the size of an array: ");
		size = scan.nextInt();
		
		arr = new int[size];

		prln("");
		
		for(int i = 0; i < arr.length; i++)
		{
			pr("\t\t     Enter value for number " + (i+1) + ": ");
			arr[i] = scan.nextInt();
		}	
	}
	
	public static void optionMenu()
	{
		prln("\n\n\t\t\t\t  Menu\n");
		prln("\t\t     1. Bubbble");
		prln("\t\t     2. Insertion");
		prln("\t\t     3. Selection");
		prln("\t\t     4. Exit\n");
		pr("\t\t     Enter Choice [1-4]: ");
		int choice = scan.nextInt();
		
		switch(choice)
		{
		case 1:
			bubble();
			
			break;
		case 2:
			insertion();
			break;
		case 3:
			selection();
			break;
		case 4:
			exit();
			break;
		default:
			break;
		}
	}
	
	public static void prArr()
	{
		pr("\t\t     ");
		for(int i = 0; i < arr.length; i++)
		{
			pr(arr[i] + " ");
		}
	}
	
	public static void pr(String print)
	{
		System.out.print(print);
	}
	
	public static void prln(String print)
	{
		System.out.println(print);
	}
	
	public static void loading()
	{
		try 
		{
			prln("\n\t\t\t\tLoading");
			pr("\t\t     |");
			printWithDelays("----------------------------", TimeUnit.MILLISECONDS, 100);
			pr("|");
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
		prln(" ________  ________  ________  _________  ___  ________   ________     ");
		prln("|\\   ____\\|\\   __  \\|\\   __  \\|\\___   ___\\\\  \\|\\   ___  \\|\\   ____\\    ");
		prln("\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\|\\  \\|___ \\  \\_\\ \\  \\ \\  \\\\ \\  \\ \\  \\___|    ");
		prln(" \\ \\_____  \\ \\  \\\\\\  \\ \\   _  _\\   \\ \\  \\ \\ \\  \\ \\  \\\\ \\  \\ \\  \\  ___  ");
		prln("  \\|____|\\  \\ \\  \\\\\\  \\ \\  \\\\  \\|   \\ \\  \\ \\ \\  \\ \\  \\\\ \\  \\ \\  \\|\\  \\ ");
		prln("    ____\\_\\  \\ \\_______\\ \\__\\\\ _\\    \\ \\__\\ \\ \\__\\ \\__\\\\ \\__\\ \\_______\\");
		prln("   |\\_________\\|_______|\\|__|\\|__|    \\|__|  \\|__|\\|__| \\|__|\\|_______|");
		prln("   \\|_________|                                                        ");
	}

}
