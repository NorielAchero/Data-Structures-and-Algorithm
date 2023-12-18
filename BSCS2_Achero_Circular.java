package cicularly_queue;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class BSCS2_Achero_Circular
{
	
	public static Scanner scan = new Scanner(System.in);
	public static int size;
	public static boolean ctrl = true;
	public static int [] arr;


	public static void main(String[] args) 
	{
		design();
		
		prln("");
		pr("  Enter the size of the Queue: ");
		size = scan.nextInt();
		
		arr = new int [size];
		

		loading();
		
		while(ctrl)
		{
			prln("\n\t       Menu");
			prln("  1. Enqueue");
			prln("  2. Dequeue");
			prln("  3. Display Queue");
			prln("  4. Exit\n");
			

				pr("  Enter Choice[1-4] ");
				int choice = scan.nextInt();
				
				switch(choice)
				{
					case 1:
						loading();
						NQ();
						loading();
						DisQ();
						break;
					case 2:
						DQ();
						loading();
						DisQ();
						break;
					case 3:
						loading();
						DisQ();
						break;
					case 4:
						loading();
						exit();
						ctrl = false;
						break;
				}

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
	
	public static int counter;
	public static int front = -1;
	public static int rear = -1;
	
	
	public static boolean NQ()
	{
		int data;
		int temp;
		
			temp = rear;
			
			rear = (rear + 1) % size;
			
			if(front == rear)
			{
				rear = temp;
				prln("\n\n  Queue is full");
				return true;
			}
			
			else
			{
				pr("\n\n  Input Number to Enqueue: ");
				counter++;
				data = scan.nextInt();
			}
			
			if(front == -1)
			{
				front = 0;
				rear = 0;
			}
			
			arr[rear] = data;
			return true;
	}
	
	public static boolean DQ()
	{

		if(front == -1)
		{
			pr("  Queue is Empty");
			return true;
		}
		
		else
		{
			arr[front] = 0;
			counter--;
		}
		
		if(rear == front)
		{
			front = -1;
			rear = -1;
		}
		else
		{
			front = (front + 1) % size;
		}
		
		return true;
	}
	
	public static void DisQ()
	{
	
		
		pr("\n\n  Queue: ");
		
		if(counter != 0)
		{
			for(int i = front; i <= counter+front; i++)
			{
				if(arr[i] != 0)
				{
					pr(arr[i] + " ");
				}
				
				if(i == arr.length-1)
				{
					break;
				}
			}
			
			if(rear < front)
			{
				for(int i = 0; i <= rear; i++)
				{
					pr(arr[i] + " ");	
				}
			}
			
			prln("\n  Front: " + front);
			prln("  Rear: " + rear  + "\n");
		}
		else
		{
			pr("Empty\n\n");
		}
			
	}

	public static void exit()
	{
		prln("\n\n  Noriel Achero | 1 BSCS 2");
	}
	
	public static void design()
	{
		prln("                           (     ");
		prln("   (                       )\\ )  ");
		prln(" ( )\\     (  (      (  (  (()/(  ");
		prln(" )((_)    )\\ )\\     )\\ )\\  /(_)) ");
		prln("((_)_  _ ((_|(_) _ ((_|(_)(_))   ");
		prln(" / _ \\| | | | __| | | | __/ __|  ");
		prln("| (_) | |_| | _|| |_| | _|\\__ \\  ");
		prln(" \\__\\_\\\\___/|___|\\___/|___|___/  ");
		prln("                                 ");
		
	}
	
	public static void loading()
	{
		try 
		{
			prln("\n\t     Loading");
			pr("  |");
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

}
