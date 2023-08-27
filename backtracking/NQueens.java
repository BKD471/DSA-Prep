package backtracking;

import java.util.ArrayList;

public class NQueens {
    ArrayList<ArrayList<String>> res=new ArrayList<>();
    private boolean validateQueen(int row,int col,char[][] board,int n){
        int tempRow=row;
        int tempCol=col;

        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }

        row=tempRow;
        col=tempCol;
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }

        row=tempRow;
        col=tempCol;
        while(row<n && col>=0){
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }
        return true;
    }

    private ArrayList<String> construct(char[][] board){
        int n=board.length;
        ArrayList<String> op=new ArrayList<>();
        for(int i=0;i<n;i++){
            String t=new String(board[i]);
            op.add(t);
        }
        return op;
    }
    private void placeQueen(char[][] board,int col,int n){
        if(col>=n){
            res.add(construct(board));
            return;
        }

        for(int row=0;row<n;row++){
            if(validateQueen(row,col,board,n)){
                board[row][col]='Q';
                placeQueen(board,col+1,n);
                board[row][col]='.';
            }
        }

    }
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        if(n==1) {
            ArrayList<String> t=new ArrayList<>();
            t.add("Q");
            res.add(t);
            return res;
        }
        if(n<=3) return res;
        char[][] board=new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) board[i][j]='.';
        }
        res.clear();
        placeQueen(board,0,n);
        return res;
    }
}
