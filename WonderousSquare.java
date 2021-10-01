import java.io.*;
public class wondrous
{
    public static void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new 
        InputStreamReader(System.in));
        System.out.println("enter the number of rows and colomn");
        int n=Integer.parseInt(br.readLine());
        System.out.println("enter the numbers");
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=Integer.parseInt(br.readLine());
            }
        }
        int r[]=new int[n];
        int c[]=new int[n];
        int co=0;
        int x=(n/2)*((n*n)+1);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                r[j]=arr[i][j];
                c[j]=arr[j][i];
            }
            if(sumr(r)!=x && sumc(c)!=x)
            {
                System.out.println("not wondrous");
                break;
            }         
            co++;
        }
        if(co==n)
        {
           System.out.println("wondrous"); 
        }
        System.out.println("prime \t row \t column");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(prime(arr[i][j])==1)
                {
                    System.out.println(arr[i][j]+"\t"+i+"\t"+j+"\t");
                }
            }
        }
    }
    public static int sumr(int arr[])
    {
        int s=0;
        for(int i=0;i<arr.length;i++)
        {
            s+=arr[i];
        }
        return s;
    }
     public static int sumc(int arr[])
    {
        int s=0;
        for(int i=0;i<arr.length;i++)
        {
            s+=arr[i];
        }
        return s;
    }              
    public static int prime(int n)
    {
        int h=0;
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
            {
                h++;
            }
        }
        if(h==2)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
