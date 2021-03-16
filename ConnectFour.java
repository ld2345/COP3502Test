import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {    // commit change
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("What would you like the height of the board to be?");  // allows user to input height and length for board
        int h = sc.nextInt();
        System.out.println("What would you like the length of the board to be?");
        int l = sc.nextInt();
        char[][] array = new char[h][l];  // initializes 2d array
        initializeBoard(array);   // initializes and prints empty board
        printBoard(array);
        System.out.println("");

        System.out.println("Player 1: x");  // tells the players what their characters are
        System.out.println("Player 2: o");
        System.out.println("");

        int x = 0;
        int row = 0;
        boolean gameOver = false;
        boolean gameDraw = false;
        while (x == 0) {

            // player 1 goes
            System.out.println("Player 1: Which column would you like to choose?");
            int col = sc.nextInt();
            char chipType = 'x';
            char chipx = 'x';
            char chipo = 'o';
            row = insertChip(array, col, chipType);  // adds chip to desired column
            printBoard(array);                       // prints new board
            System.out.println("");
            gameOver = checkIfWinner(array, col, row, chipType);   // checks if there is a winner
            if (gameOver) {
                System.out.println("Player 1 won the game!");
                break;
            }
            gameDraw = checkIfDraw(array, chipx, chipo);          // checks if there is a draw
            if (gameDraw) {
                System.out.println("Draw. Nobody wins.");
                break;
            }

            // player 2 goes
            System.out.println("Player 2: Which column would you like to choose?");
            col = sc.nextInt();
            chipType = 'o';
            chipx = 'x';
            chipo = 'o';
            row = insertChip(array, col, chipType);   // adds chip to desired column
            printBoard(array);                        // prints new board
            System.out.println("");
            gameOver = checkIfWinner(array, col, row, chipType);    // checks if there is a winner
            if (gameOver) {
                System.out.println("Player 2 won the game!");
                break;
            }
            gameDraw = checkIfDraw(array, chipx, chipo);            // checks if there is a draw
            if (gameDraw) {
                System.out.println("Draw. Nobody wins.");
                break;                                              // ends program if there is a draw
            }
        }
    }


    public static void initializeBoard(char[][] array) {

        int length1 = array.length;
        int length2 = array[0].length;
        for(int row = 0; row < length1; row++) {
            for (int col = 0; col < length2; col++) {
                array[row][col] = '-';                    // initializes every element in the array to be -
            }
        }
    }

    public static void printBoard(char[][] array) {
        int length1 = array.length;
        int length2 = array[0].length;

        for (int row = length1 - 1; row >= 0; row--) {
            for (int col = 0; col < length2; col++) {
                System.out.print(array[row][col] + " ");   // prints the empty grid
            }
            System.out.println();
        }
    }


    public static int insertChip(char[][] array, int col, char chipType) {

        int length1 = array.length;
        int length2 = array[0].length;
        int row = 0;

        for (int i = 0; i < length1; i++) {   // iterates through the desired column

            row = i;
            if (array[i][col] == '-') {      // checks to make sure spot is empty before inserting chip
                array[i][col] = chipType;
                break;
            }
        }
        return row;
    }

    public static boolean checkIfWinner (char[][] array, int col, int row, char chipType) {   // method to check if there is a winner

        int length1 = array.length;
        int length2 = array[0].length;
        boolean gameOver = false;
        int count = 0;

        for(int i = 0; i < length1; i++) {   // checks column

            if (array[i][col] == chipType) {
                count++;
            }
            if (count == 4) {
                gameOver = true;
                break;
            }
        }
        count = 0;  // resets count


        for (int i = 0; i < length2; i++) {   // checks row

            if (array[row][i] == chipType) {
                count++;
            }
            if (count == 4) {
                gameOver = true;
                break;
            }
        }

        return gameOver;    // returns boolean true or false whether a player won the game
    }



    public static boolean checkIfDraw (char[][] array, char chipx, char chipo) {   // method to check if there is a draw

        int count = 0;
        boolean gameDraw = false;
        int length1 = array.length;
        int length2 = array[0].length;
        for(int row = 0; row < length1; row++) {             // iterates through the entire array
            for (int col = 0; col < length2; col++) {

                if (array[row][col] == chipx) {              // increases count if there is an x
                    count++;
                }
                if (array[row][col] == chipo) {              // increases count if there is an o
                    count++;
                }
                if (count == (length1 * length2)) {          // sets boolean to true if entire grid is full
                    gameDraw = true;
                    break;
                }
            }
        }

        return gameDraw;
    }
}
