import java.awt.*;
import java.util.ArrayList;

public class Board {
    int[] boardState = new int[3];
    boolean isWinning;
    Point bMove;


    public Board(int i, int j, int t, int row, int col){
        boardState[0] = i;
        boardState[1] = j;
        boardState[2] = t;


        bMove = new Point(row, col);


        //if(boardState == lBoards){
           // System.out.println("Losing Board");
        }


    }


