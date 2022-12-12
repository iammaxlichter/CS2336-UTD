package CS2336.InClass;

import java.util.Scanner;

public class Polynomial {
    
    private int coefficients[];

    //assumption: array is already ordered the way we expect....
    public Polynomial(int array[]){
        coefficients = new int [array.length];
        System.arraycopy(array, 0, coefficients, 0, array.length);
    }

    //  5x^2 + 7x + 2
    // "5 7 2" --> ["5", "7", "2"] --> [2, 7, 5]
    public Polynomial(String line){
        String pieces[] = line.split(" ");
        coefficients = new int [pieces.length];
        for(int i = 0; i<pieces.length; i++){
            coefficients[pieces.length-1-i] = Integer.parseInt(pieces[i]);
        }  
    }

    public Polynomial add(Polynomial second){
        //we should add this object and second object 
        // this.coefficients[] second.coefficients[] -> temp[]

        int temp[] = new int[Math.max(this.coefficients.length, second.coefficients.length)];
    

        System.arraycopy(this.coefficients, 0, temp, 0, this.coefficients.length);

        for(int i = 0; i < second.coefficients.length; i++){
            temp[i] += second.coefficients[i];

        }
        return new Polynomial(temp);
    }

    public Polynomial multiply(Polynomial second){
        int length1 = this.coefficients.length;
        int length2 = second.coefficients.length;
        
        int temp[] = new int[length1 + length2 - 1];

        System.arraycopy(this.coefficients, 0, temp, 0, this.coefficients.length);

        for(int i = 0; i<length1; i++){
            for (int j = 0; j < length2; j++){
                temp[i+j] += this.coefficients[i] * second.coefficients[j];
            }
        }
        return new Polynomial(temp);
    }

    public String toString(){
        String result = "";
        for(int i = 0; i<this.coefficients.length; i++){
           result += this.coefficients[i] + " ";
        }  

        return result;
    }
    public static void main(String args[]){


        Scanner input = new Scanner(System.in);

        Polynomial p1 = new Polynomial(input.nextLine());
        Polynomial p2 = new Polynomial(input.nextLine());
        System.out.println(p1.add(p2));
        System.out.println(p1.multiply(p2));


        input.close();
    }
}
