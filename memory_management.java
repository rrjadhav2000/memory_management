

import java.util.*;
class parts
{
	int flag[];
	int part[] ;
	int pid[] ;
	Scanner sc=new Scanner(System.in);
	public parts(int p_size,int n)
	{
		part=new int[p_size];
		pid=new int[n];
		flag=new int[10];
	}
	
	public void create(int b_size,int n)  //Accept the memory block partiton size and process size
	{
		for(int i=0;i<n;i++)
		{
			pid=new int[n];
		}
		for(int i=0;i<b_size;i++)
		{
			part=new int[b_size];
		}
		
		for(int i=0;i<b_size;i++)
		{
			System.out.println("\nEnter the memory block for partition "+(i+1));
			part[i]=sc.nextInt();
		}
		System.out.println("============================================================");
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the size of process P"+(i));
			pid[i]=sc.nextInt();
			System.out.println();
		}
	}
	public void firstfit(int b_size,int n)  //First fit 
	{
		for(int j=0;j<b_size;j++)
		{
			flag[j]=0;
		}
		int first;
		System.out.println("\t==========================================================================================================");
		System.out.println("\tPROCESS ID\t\tPROCESS SIZE\t\tPROCESS ALLOCATED OR UNALLOCATED\t\tBLOCK SIZE");
		System.out.println("\t==========================================================================================================");
		for(int i=0;i<n;i++)
		{
			first=1;
			for(int j=0;j<b_size;j++)
			{
				if(flag[j]==0 && pid[i]<=part[j])
				{
					flag[j]=1;
					System.out.println("\tP"+i+"\t\t\t"+pid[i]+"\t\t\tAllocated\t\t\t\t\t"+part[j]);
					break;
				}
				else
				{  
					first++;
				}
			}
			if(first>b_size)
			{
				System.out.println("\tP"+i+"\t\t\t"+pid[i]+"\t\t\tUnallocated\t\t\t\t\t---");
			}
		}
	}	
	
	public void worstfit(int b_size,int n)  //Worst fit
	{
		for(int i=0;i<b_size;i++)
		{
			flag[i]=0;
		}
		int temp,tap;
		for(int i=0;i<b_size;i++) 			//BUBBLE SORT
		{
			for(int j=i;j<b_size;j++)
			{
				if(part[i]<part[j])
				{
					temp=part[i];
					part[i]=part[j];
					part[j]=temp;
				}
			}
		}
		
		System.out.println("\t==========================================================================================================");
		System.out.println("\tPROCESS ID\t\tPROCESS SIZE\t\tPROCESS ALLOCATED OR UNALLOCATED\t\tBLOCK SIZE");
		System.out.println("\t==========================================================================================================");
		for(int i=0;i<n;i++)
		{
			tap=1;
			for(int j=0;j<b_size;j++)
			{
				if(flag[j]==0 && pid[i]<=part[j])
				{
					flag[j]=1;
					System.out.println("\tP"+i+"\t\t\t"+pid[i]+"\t\t\tAllocated\t\t\t\t\t"+part[j]);
					break;
				}
				else
				{  
					tap++;
				}
			}
			if(tap>b_size)
			{
				System.out.println("\tP"+i+"\t\t\t"+pid[i]+"\t\t\tUnallocated\t\t\t\t\t---");
			}
		}
	}
	
	public void bestfit(int b_size,int n)  //Best fit
	{
		int min,i,j;
		int current;
		int worst;
		int loc = 0;
		for(int m=0;m<b_size;m++)
		{
			flag[m]=0;
		}
		System.out.println("\t==========================================================================================================");
		System.out.println("\tPROCESS ID\t\tPROCESS SIZE\t\tPROCESS ALLOCATED OR UNALLOCATED\t\tBLOCK SIZE");
		System.out.println("\t==========================================================================================================");
		for(i=0;i<n;i++)
		{
			worst=1;
			current=999;
			for(j=0;j<b_size;j++)
			{
				min=part[j];
				if(flag[j]==0 && pid[i]<=part[j])
				{
					if(current>min)
					{
						current=min;
						loc=j;
					}
				}
				else
				{
					worst++;
				}
			}
			if(worst>b_size)
			{
				System.out.println("\tP"+i+"\t\t\t"+pid[i]+"\t\t\tUnallocated\t\t\t\t\t---");
			}
			else
			{
				j=loc;
				System.out.println("\tP"+i+"\t\t\t"+pid[i]+"\t\t\tAllocated\t\t\t\t\t"+current);
				flag[j]=1;
			}
		}
	}
}

public class memory_managment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b_size ,n;
		Scanner sb=new Scanner(System.in);
		System.out.println("\nEnter the no. of memory partition: ");
		b_size=sb.nextInt();
		System.out.println("\nEnter the no. of process: ");
		n=sb.nextInt();
		int ch;
		parts part=new parts(b_size,n);
		 
		
		do
		{
		System.out.println("\n1.Create \n2.First fit \n3.Worst fit \n4.Best fit");
		ch=sb.nextInt();
		switch(ch)
		{
		case 1:
			part.create( b_size, n);
			break;
		case 2:
			System.out.println("\t\t******************FIRST FIT************************");
			System.out.println();
			part.firstfit(b_size,n);
			break;
		case 3:
			System.out.println("\t\t******************WORST FIT************************");
			System.out.println();
			part.worstfit(b_size,n);
			break;
		case 4:
			System.out.println("\t\t******************BEST FIT************************");
			System.out.println();
			part.bestfit(b_size,n);
			break;
		}
		}while(ch!=0);
		}
}

/*
 * OUTPUT:
 *  Enter the no. of memory partition: 
5

Enter the no. of process: 
4

1.Create 
2.First fit 
3.Worst fit 
4.Best fit
1

Enter the memory block for partition 1
100

Enter the memory block for partition 2
500

Enter the memory block for partition 3
200

Enter the memory block for partition 4
300

Enter the memory block for partition 5
600
============================================================
Enter the size of process P0
212

Enter the size of process P1
417

Enter the size of process P2
112

Enter the size of process P3
426


1.Create 
2.First fit 
3.Worst fit 
4.Best fit
2
		******************FIRST FIT************************

	==========================================================================================================
	PROCESS ID		PROCESS SIZE		PROCESS ALLOCATED OR UNALLOCATED		BLOCK SIZE
	==========================================================================================================
	P0			212			Allocated					500
	P1			417			Allocated					600
	P2			112			Allocated					200
	P3			426			Unallocated					---

1.Create 
2.First fit 
3.Worst fit 
4.Best fit
3
		******************WORST FIT************************

	==========================================================================================================
	PROCESS ID		PROCESS SIZE		PROCESS ALLOCATED OR UNALLOCATED		BLOCK SIZE
	==========================================================================================================
	P0			212			Allocated					600
	P1			417			Allocated					500
	P2			112			Allocated					300
	P3			426			Unallocated					---

1.Create 
2.First fit 
3.Worst fit 
4.Best fit
4
		******************BEST FIT************************

	==========================================================================================================
	PROCESS ID		PROCESS SIZE		PROCESS ALLOCATED OR UNALLOCATED		BLOCK SIZE
	==========================================================================================================
	P0			212			Allocated					300
	P1			417			Allocated					500
	P2			112			Allocated					200
	P3			426			Allocated					600

1.Create 
2.First fit 
3.Worst fit 
4.Best fit

*/