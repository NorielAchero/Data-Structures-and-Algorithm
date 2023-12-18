
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;  
import java.util.Date;  


public class BSCS2_Manliguez_Achero_Final	
{
	static DecimalFormat dff = new DecimalFormat("$#,###.00");
	static DecimalFormat df = new DecimalFormat("#,###.00");
	static Scanner scan = new Scanner (System.in); 
	static int[] buyShares; 
	static double[] buySharesVal; 
	static int [] sellShares; 
	static double [] sellSharesVal; 
	static int totalBuyShares = 0;
	static int days; 
	static int[] calShares; 
	static double [] calVal;
	static double [] finalCal;
	static double gainLoss = 0; 
	static String userName = "";
    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");  
    static Date date = new Date();  
    static String dateFormat = formatter.format(date); 
    static int sShares;
    static int cal;
	
	public static void main(String[] args)
	{
		println("\n	                    SKL Transactions");
		initialize();
		transaction();
		design();
	}
	
	public static void transaction()
	{
		int buyCtrl = 0;
		int sellCtrl = 0;
		int i;
		
		
		String receiptName = userName + " Transaction " + dateFormat;
		
		try 
		{
			File myObj = new File(receiptName);
			if(myObj.createNewFile())
			{
				
			FileWriter myWriter = new FileWriter(receiptName);	
				
			myWriter.write("SKL Transaction Receipt\n\n");
			myWriter.write("Transaction of " + userName + " - " + dateFormat + "\n");
			
			for(i = 0; i < days - 1; i++)
			{
				println("\n				  DAY " + (i+1) + "\n");
				myWriter.write("\nDAY " + (i+1));
				
				print("	Please enter the number and value of your buy shares below. \n");
	
					print("	Number of shares to buy: ");
					int bShares = scan.nextInt();
					
					buyShares[buyCtrl] = bShares;
					totalBuyShares = totalBuyShares + bShares;
					
					print("	Value of shares to buy: ");
					double bSharesAmount = scan.nextDouble();
					
					buySharesVal[buyCtrl] = bSharesAmount;
					
					myWriter.write("\nBought " + bShares + " Shares at " + dff.format(bSharesAmount) + " each\n");
					
					buyCtrl++;
					
					println("");
					loading();
			}
			
			boolean sellFlag = true;
			
			while(sellFlag)
			{
				if(i == days-1)
				{
					println("\n				  DAY " + (i+1) + "\n");

					print("	Please enter the number and value of your sell shares below. \n");
					print("	Input number of shares to sell: ");
					sShares = scan.nextInt();
						
					sellShares[sellCtrl] = sShares;
						
					print("	Input value of shares to sell: ");
					double sSharesAmount = scan.nextDouble();
						
					sellSharesVal[sellCtrl] = sSharesAmount;
					
					println("");
					loading();
					
					if(sShares <= totalBuyShares)
					{
						myWriter.write("\nDAY " + (i+1));
						myWriter.write("\nSold " + sShares + " Shares at " + dff.format(sSharesAmount) + " each\n");
						
						calculation(sellCtrl);	
						sellFlag = false;
					}
				
					else if(sShares > totalBuyShares)
					{
						println("		   You cannot sell more than you bought.");
						sellFlag = true;
					}
					println("");
				}
			}
			
			myWriter.write("\nCalculations:\n");
			
			for(int b = 0; b < cal; b++)
			{
				myWriter.write(df.format(calShares[b]) + " * " + df.format(calVal[b]));
				
				if(b != cal-1)
				{
					myWriter.write(" + ");
				}
				else
				{
					myWriter.write(" = " + df.format(gainLoss));
				}
			}
			
			myWriter.write("\n\nThe Gain/Loss is " + dff.format(gainLoss));
			
			
			myWriter.write("\n\nThank you for using SKL Transactions!");
			
			myWriter.close();
			}
			
		}
		catch (IOException e)
		{
			System.out.println("\n	     An error occurred, please restart and choose other username.");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public static void calculation(int index)
	{
	
		cal = 0;
		for(int i = 0; buyShares[i] != 0; i++, cal++)
		{
				if(sellShares[index] >= buyShares[i])
				{
				calShares[cal] = buyShares[i]; 
				sellShares[index] = sellShares[index] - buyShares[i];  
				}
				
				else if(sellShares[index] < buyShares[i])
				{
					calShares[cal] = sellShares[index]; 
					sellShares[index] = 0;
				}
		}
		
		for(int a = 0; a < cal; a++)
		{
			calVal[a] = sellSharesVal[index] - buySharesVal[a];
		}
		System.out.println();
		
		display();
		System.out.println();
		print("   ");
		for(int b = 0; b < cal; b++)
		{
			print(df.format(calShares[b]) + " * " + df.format(calVal[b]));
			finalCal[b] = calShares[b] * calVal[b];
			
			gainLoss = gainLoss + finalCal [b];
			
			if(b != cal-1)
			{
				print(" + ");
			}
			else
			{
				println(" = " + df.format(gainLoss));
			}
				
		}

		System.out.println();
		System.out.println("			The Gain/Loss is " + dff.format(gainLoss));
	}
	
	public static void initialize()
	{
		print("\n	            Enter username for transaction: ");
		userName = scan.next();
		
		print("\n	     How many days would like to make a transaction? ");
		days = scan.nextInt();
		
		println("\n		  	  You've entered " + days + " days.");
		println("      	   	Processing your transaction, please wait. \n");
		loading();
		buyShares = new int [days];
		buySharesVal = new double [days];
		sellShares = new int [days];
		sellSharesVal = new double [days];
		calShares = new int [days];
		calVal = new double [days];
		finalCal = new double [days];
	}
	
	public static void display()
	{	
		for(int i = -1;  i < days-1; i++)
		{
			if(i == -1)
			{
				print("   " + sShares + " shares sold, ");
			}
			else if(i != -1 && i!= days-1)
			{
				print(calShares[i] + " were bought on day " + (i+1) + ", ");
			}
			else
			{
				print(calShares[i] + " were bought on day " + (i+1) + ".");
			}	
		}
	}
	
	public static void prArrInt(int [] arr)
	{
		for(int i = 0; i < days; i ++)
		{
			print(arr[i] + " ");
		}
	}
	
	public static void prArrDouble(double [] arr)
	{
		for(int i = 0; i < days; i ++)
		{
			print(arr[i] + " ");
		}
	}
	
	public static void print(String pr)
	{
		System.out.print(pr);
	}
	
	public static void println(String pr)
	{
		System.out.println(pr);
	}
	
	static void loading()
	{
		print("	|--");
		try {
			for (int count = 0; count < 55; count++)
			{
				TimeUnit.MILLISECONDS.sleep(100);
				print("-");
			}
			println("|");
		}
		catch (Exception e)
		{
		
		}
	}
	
	
	public static void design()
	{
		
		System.out.println("\n	                         THANK YOU!");
		System.out.println("");
		System.out.println("                                  @#/.#%(%                                                \r\n"
				+ "                              (###&#.##@##%%%                                             \r\n"
				+ "                            **%%#%// ,(#%#/#(##                                           \r\n"
				+ "                           ((%(##/*,,,***(###*((                                          \r\n"
				+ "                          %%###((/******,**/%%%%#                                         \r\n"
				+ "                         #%%(###(//**//(/****(&%&#%                                       \r\n"
				+ "                         #/%&((&&%((**/((/*,,*%%%%#.                                      \r\n"
				+ "                        /%&&&#(***//*,*/**,,,,#(&%#/                                      \r\n"
				+ "                        #%%&&&/**//#(//**/(*,,&&%%%(/                                     \r\n"
				+ "                       *%%%&&@(//(&#(/(*/***,&&&#%#((,                                    \r\n"
				+ "                     **#%#%&@&@@@((///**,,,*/@&&#&%/(/,                                   \r\n"
				+ "                     **#&&%@&&@@@@&##/**/****(&&&#%(*..                                   \r\n"
				+ "                      #%%%@&&&@@@@&%#((//*****/(/(##,                                     \r\n"
				+ "                     ##%#%&@&&&@@&%##(/////***(,,,*...                                    \r\n"
				+ "                    */%#%&%&&%(/@@@%,********.,.,,*#.., . ..                              \r\n"
				+ "                   .,.,.//%&&/,,,/#,,,,.,,,@,....,,,,   ,..,,..                           \r\n"
				+ "                   . ...,,*(%&.,........,.#/,,..,,,.. .  ,.,,,,..                         \r\n"
				+ "                  ......&/,(%/........&*.,(/.,,.,,.       ,,,,,,,..                       \r\n"
				+ "                  #,,,...,.//*@,..........,..,,,,.   *.,. ,,,,,,,,,..                     \r\n"
				+ "                 .,,.,...,./,,*/. ...,  */,*,..,...   ..   /,,,,,,,,,...                  \r\n"
				+ "                 .,,,,,..,.(.,,,,,*. .. /.., ,,,,     .    ,,,,,,*,,,,*/.                 \r\n"
				+ "                 .,,,,...,.*,,,,............ ..,*,., .,....,..,.. /((((/*,                \r\n"
				+ "                 ,,,,,,,.,./,,,,.,,... . ..,.,,.*.,,,,....,,,..,   /((/*..,,     ");
		
		System.out.println("\n	                    ANGELICA MAE MANLIGUEZ\n\n");
		
		System.out.println("                                     (&@&&&&&&@                                           \r\n"
				+ "                                  .&@@@@@@@@&&&@&@                                        \r\n"
				+ "                               &@@@&%%####%&&&@@@&@@                                      \r\n"
				+ "                              @@@&&##((///(/(#@@@@@&@                                     \r\n"
				+ "                              &@&&%#((///******/(%&@@                                     \r\n"
				+ "                              &@@&#####(##(/(((//(#@/                                     \r\n"
				+ "                              .%&&#((///((/*/*////#&                                      \r\n"
				+ "                               %%##((/*/((*,//****%/                                      \r\n"
				+ "                                ,#((((((((/****////                                       \r\n"
				+ "                                  #((((##((/(////,                                        \r\n"
				+ "                                   #((##((//////                                          \r\n"
				+ "                                 ,/###((#####((                                           \r\n"
				+ "                             ,******%#(((((/(/(.                                          \r\n"
				+ "                        *,,,,*,******,((((((((..,..                                       \r\n"
				+ "                   .......,.,,,,*,,,*,,,.#((...........                                   \r\n"
				+ "                 *,,.,*......,,...,....%#(//(..,......,....,                              \r\n"
				+ "                **/,,../......,,...,**/%/(///(,.......,......                             \r\n"
				+ "                **,*.,.,.......,,....,/#(//(,..........,......          ");
		
		System.out.println("\n	                         NORIEL ACHERO");
		
		
		System.out.println("\n	             1 BSCS 2 | DATA STRUCTURES AND ALGORITHM");
		
	}
	

}
