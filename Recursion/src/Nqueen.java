import java.util.ArrayList;
import java.util.List;

import static helper.CodeHelper.displayListOfListString;

class Solution8 {
    public static boolean isValidMove(int row,int col,char[][] board,int n){
        int orgRow=row;
        int orgCol=col;

        // Check uper diagonally if another Queen is already present in previous col
        while(col>=0 && row>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        row=orgRow;
        col=orgCol;

        // Check horizontaly(row is constant here) if quenn is present
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        row=orgRow;
        col=orgCol;

        //Check lower diagonall whther queen is present
        while(row<n && col>=0){
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }
        return true;
    }

    public static List<String> buildListOfString(char[][] board, int n){
        List<String> temp=new ArrayList();
        for(int i=0;i<n;i++){
            String s=new String(board[i]);
            temp.add(s);
        }
        return temp;
    }

    public static void solve(int col,char[][] board,List<List<String>> res,int n){
        if(col==n){
            res.add(buildListOfString(board,n));
            return;
        }
        for(int row=0;row<n;row++){
            if(isValidMove(row,col,board,n)){
                board[row][col]='Q';
                solve(col+1,board,res,n);
                //Removing queen if combo is not valid /unable to finish the combo
                // this is how Backtracking works
                board[row][col]='.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        solve(0,board,res,n);
        return res;
    }
}
public class Nqueen {
    public static void main(String[] args) {
        int n=4;
        List<List<String>> res=Solution8.solveNQueens(n);
        displayListOfListString(res);
    }
}
