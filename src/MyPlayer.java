import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    ArrayList <Board> wBoards = new ArrayList<>();
    ArrayList <Board> lBoards = new ArrayList<>();

    public MyPlayer() {
        columns = new int[10];

//        lBoards.add(new Board(1,0,0,0,0));

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        for (int i=1; i<=3; i++){
            for(int y=0; y<=3; y++){
                for(int t=0;t<=3;t++){
                    if(i>=y && i>=t && y>=t){


                        System.out.println("Board:"+i+","+y+","+t);
                        ResultBoard(i,y,t);
                    }

                }

            }

        }

        // print all winning and losing boards to make sure it's working correctly

        System.out.println("losing boards");
        for (int x=0; x< lBoards.size(); x++ ){
            System.out.println(lBoards.get(x).boardState[0] + " " + lBoards.get(x).boardState[1] + " " + lBoards.get(x).boardState[2]);
        }
        System.out.println("winning boards");
        for (int x=0; x< wBoards.size(); x++ ) {
            System.out.println(wBoards.get(x).boardState[0] + " " + wBoards.get(x).boardState[1] + " " + wBoards.get(x).boardState[2]);
        }




    }
    public void ResultBoard(int i, int j, int t){
        boolean u;
        int t1 = t;
        int i1 = i;
        int j1 = j;

        boolean foundLoser = false;
        int tempRow = 0;
        int tempCol = 0;

        for(int k = t-1; k>=0; k--){
            // if(j = )
            System.out.println("r1:  "+i+","+j+","+k+" ("+(k)+",2)");

            for (int x = 0; x < lBoards.size(); x++){
                if ( lBoards.get(x).boardState[0] == i && lBoards.get(x).boardState[1] == j && lBoards.get(x).boardState[2] == k ){
                    System.out.println("IT WORKED");
                    foundLoser = true;
                    tempRow = k;
                    tempCol = 2;
                }
            }

        }

        for(int q = j-1;q>=0; q--){
            if(t > q){
                t=q;
            }
            System.out.println("r2:  "+i+","+q+","+t+" ("+(q)+",1)");
            for (int x = 0; x < lBoards.size(); x++){
                if ( lBoards.get(x).boardState[0] == i && lBoards.get(x).boardState[1] == q && lBoards.get(x).boardState[2] == t ){
                    System.out.println("IT WORKED");
                    foundLoser = true;
                    tempRow = q;
                    tempCol = 1;
                }
            }

        }
        t = t1;

        for(int i2= i-1; i2 >= 1; i2--) {
            if (j > i2) {
                j = i2;
            }
            if (t >= j) {
                t = j;
            }
            System.out.println("r3:  " + i2 + "," + j + "," + (t) + " (" + (i2) + ",0)");

            for (int x = 0; x < lBoards.size(); x++){
                if ( lBoards.get(x).boardState[0] == i2 && lBoards.get(x).boardState[1] == j && lBoards.get(x).boardState[2] == t ){
                    System.out.println("IT WORKED");
                    foundLoser = true;
                    tempRow = i2;
                    tempCol = 0;
                }
            }
        }
        t = t1;
        j = j1;

        if (foundLoser == true) {
            wBoards.add(new Board(i, j, t,tempRow,tempCol));
        }
        else{
            lBoards.add(new Board(i,j,t,tempRow,tempCol));
        }
    }
    // sort original board into winning vs losing
    // if set of result boards has a losing board in it, original board is a winner
    // otherwise, it's a loser


    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;

        columns = makeColumns(gameBoard);

        int column = 0;
        int row = 0;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */
        Point myMove = new Point(row, column);

        for(int x=0; x<wBoards.size(); x++){
            if (wBoards.get(x).boardState[0] == columns[0] && wBoards.get(x).boardState[1] == columns[1] && wBoards.get(x).boardState[2] == columns[2]) {
                myMove = wBoards.get(x).bMove;
            }

        }
        // if row and col are still 0s, you need to figure out how to treat losing boards



        return myMove;
    }

    public int[] makeColumns(Chip[][] gameBoard) {
        int[] cols = new int[10];

        for (int c = 0; c < 10; c++) {
            for (int r = 0; r < 10; r++) {
                if (gameBoard[r][c].isAlive == true) {
                    cols[c]++;
                }
            }
        }

        return cols;
    }

}
