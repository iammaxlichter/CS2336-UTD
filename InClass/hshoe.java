package CS2336.InClass;

import java.util.*;
import java.io.*;

class hshoe {
    static char matrix[][];
    static int maxLength = 0;
    static int size = 0;

    static void findMaxOpen(int length, int row, int column){
        //Record the current length as max if it is larger
        if(length > maxLength)
            maxLength = length;
        

        //end condition?
        if (row < 0 || row > size || column < 0 || column > size)
            return;
        

        if(matrix[row][column] != '(')
            return;
        
        matrix[row][column] = '.'; //avoid snake biting its tail..
        //recursive inocations?
        findMaxOpen(length+1,row,column+1);
        findMaxOpen(length+1,row,column-1);
        findMaxOpen(length+1,row+1,column);
        findMaxOpen(length+1,row-1,column);
        matrix[row][column] = '('; //reset back to original content
    }

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("hshoe.in"));
		PrintWriter output = new PrintWriter("hshoe.out");

        int size = input.nextInt();
        matrix = new char [size][]; //memory for references for each row
        for(int i=0; i<size; i++) {
            String line = input.next();
            matrix[i] = line.toCharArray();
            //one line version: matrix[i] = input.next().toCharArray();
        }
            
        //now we can access individual character as matrix[i][j]
        findMaxOpen(0,0,0);
		output.println(maxLength);
		output.close();
	}
}