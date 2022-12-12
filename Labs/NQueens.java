package CS2336.Labs;
import java.util.Scanner;

public class NQueens {
    //n * n board to place queens: 
    // 'Q' indicates Queen is present in that position, ' ' indicates NO queen
    public static char board[][]; 
    public static int solutionCount = 0;

    public static boolean okToPlace(int row, int column) {
      int i = 0, j = 0;

      for (i = row, j = column; i >= 0 && j < board.length; i--, j++) {
        if (board[i][j] == 'Q')
          return false;
      }
      for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q')
          return false;
      }
      for (i = 0; i < row; i++) {
        if (board[i][column] == 'Q') {
          return false;     
          }
      }
      return true;
    }

    public static void placeQueens(int row) {

      if (row >= board.length) {
        solutionCount++;
        return;
      }
      for (int i = 0; i < board.length; i++)
        if(okToPlace(row, i) == true){
            board[row][i] = 'Q';
            placeQueens(row+1);
            board[row][i] = ' ';
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int boardSize = input.nextInt();
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                board[i][j] = ' ';
        
        placeQueens(0); 
        System.out.println(solutionCount);

        input.close();
    }
}
