package CS2336.InClass;

//Recursive function compute and print factorial of first 50 numbers
public class Factorial {
    
    public static long recursiveFactorial(long n){

        if(n==0){
            return 1;
        }
        else{
            return n * recursiveFactorial(n-1);
        }
    }

    public static long nonRecursiveFactorial(long n){

        //n! = 1 * 2 * 3 * 4 * .... n

        long result = 1;
        for(int i = 1 ; i <= n ; i++){
            result *=i;
        }

        return result;
    }
    public static void main(String[] args){

        System.out.println("Recursion based output:");
        for (int i=0; i<=50; i++){
            System.out.println("f(" + i + "): " + recursiveFactorial(i));
        }

        System.out.println("Non Recursion based output:");
        for (int i=0; i<=50; i++){
            System.out.println("f(" + i + "): " + nonRecursiveFactorial(i));
        }

    }
}
