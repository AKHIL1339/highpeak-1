import java.util.Arrays;// import array methods 
import java.util.Scanner;//import the  packages to the scanner which takes input from the user

public class Highpeak {

    static int minDiff(int array[], int N, int M)//method to define the difference between highest and lowest price
    {
        int result = Integer.MAX_VALUE;
        Arrays.sort(array);
        for (int i=0; i<= N-M;i++)
            result = Math.min(result, array[i + M - 1] - array[i]);
        return result;
    }

    static int findelements(int res,int array[], int N, int M)//method which returns the index values of starting  low price (M) list of the goodies
    {
        int result = Integer.MAX_VALUE;
        for(int i=0; i<=N; i++)
        {
            result = Math.min(result, array[i + M - 1] - array[i]);
            if (res==result)
                return i;
        }
        return 0;
    }
    // main method from which the program starts execution process
    public static void main(String[] args) { 

        int array[]={7980,22349,999,2799,229900,11101,9999,2195,9800,4999};// array which gives goodies price values
        String items[]={ "MI Band: 999","Sandwich Toaster: 2195" ,"Cult Pass: 2799","Scale: 4999","Fitbit Plus: 7980","Microwave Oven: 9800"  ,"Alexa: 9999","Digital Camera: 11101", "IPods: 22349","Macbook Pro: 229900" };//array of type string which gives information about goodies and their prices
        int N = array.length;//length of the array
        System.out.println("Enter the number of employees");
        Scanner s = new Scanner(System.in);
        int M=s.nextInt();// number of employees
        int result=minDiff(array, N, M);// calling the min Differance method by giving array and length of the array and number of employees information
        System.out.println("Number of the employees:"+M);//prints the number of employees
        int startindex=findelements(result,array,N,M);//calling the minDiff method by giving array and length of the array and number of employees information
        System.out.println("Here the goodies that are selected for distribution are:");
        for(int i=startindex;i<startindex+M;i++)//loop which prints the starting least M goodies from the items array
            System.out.println(items[i]);
        System.out.println("\n");//skips to the next line
        System.out.println("And the difference between the chosen goodies with highest price and the lowest price is:"+result);//prints the difference between highest and lowest price of goodies
    }
}