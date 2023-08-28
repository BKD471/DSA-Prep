package backtracking;

public class Sudoku {
    private boolean isPossible(char[][] board,int row,int col,char c){
         for(int i=0;i<9;i++){
             if(board[row][i]==c) return  false;
             if(board[i][col]==c) return  false;
             if(board[3*(row/3)+row/3][3*(col/3)+col%3]==c) return false;
         }
         return true;
    }
    private boolean buildSudoku(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='.'){
                   for(char c='1';c<='9';c++){
                       if(isPossible(board,i,j,c)){
                           if(buildSudoku(board)) return  true;
                           else  board[i][j]='.';
                       }
                   }
                    return false;
                }
            }
        }
        return true;
    }
    private void solve(char[][] board){
        buildSudoku(board);
    }
}
