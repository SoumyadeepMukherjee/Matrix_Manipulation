import java.util.*;
public class MatAdd
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number of Rows in the Matrix");
		int n=sc.nextInt();
		System.out.println("Enter the Number of Columns in the Matrix");
		int m=sc.nextInt();
		int a[][]=new int[n][m];
		int b[][]=new int[n][m];
		int c[][]=new int[n][m];
		System.out.println("Enter Values in the First Matrix");
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Values in Row "+(i+1));
			for(int j=0;j<m;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter Values in the Second Matrix");
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Values in Row "+(i+1));
			for(int j=0;j<m;j++)
			{
				b[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				c[i][j]=a[i][j]+b[i][j];
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(" ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(" ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(" ");
	}
}