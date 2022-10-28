import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];

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
    }
    public void ResultBoard(int i, int j, int t){
        boolean u;
        int t1 = t;
        int i1 = i;
        int j1 = j;
        for(int k = t-1; k>=0; k--){
           // if(j = )
            System.out.println("r1:  "+i+","+j+","+k+" ("+(k)+",2)");

        }
        for(int q = j-1;q>=0; q--){
            if(t > q){
                t=q;
            }
            System.out.println("r2:  "+i+","+q+","+t+" ("+(q)+",1)");

        }

        t = t1;
        for(int i2= i-1; i2 >= 1; i2--){
            if(j > i2){
                j = i2;
            }
            if(t >= j){
                t = j;
            }
            System.out.println("r3:  "+i2+","+j+","+(t)+" ("+(i2)+",0)");
        }

    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;
    }

}
