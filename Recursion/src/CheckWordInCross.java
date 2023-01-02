
class Solution34 {
    public static boolean checkLeft(char[][] board,String word,int row,int col,int m,int n){

        int size=word.length();
        if(col+1<n && board[row][col+1]!='#') return false;
        if(col-size>=0 && board[row][col-size]!='#') return false;

        for(int i=0;i<size;i++){
            if(col-i<0) return false;
            if(board[row][col-i]==' ' || word.charAt(i)==board[row][col-i]) continue;
            else return false;
        }
        return true;

    }

    public static boolean checkRight(char[][] board,String word,int row,int col,int m,int n){

        int size=word.length();
        if(col-1>=0 && board[row][col-1]!='#') return false;
        if(col+size<=n-1 && board[row][col+size]!='#') return false;

        for(int i=0;i<size;i++){
            if(col+i>=n) return false;
            if(board[row][col+i]==' ' || word.charAt(i)==board[row][col+i]) continue;
            else return false;
        }
        return true;
    }


    public static boolean checkDown(char[][] board,String word,int row,int col,int m,int n){

        int size=word.length();
        if(row-1>=0 && board[row-1][col]!='#') return false;
        if(row+size<=m-1 && board[row+size][col]!='#') return false;

        for(int i=0;i<size;i++){
            if(row+i>=m) return false;
            if(board[row+i][col]==' ' || word.charAt(i)==board[row+i][col]) continue;
            else return false;
        }
        return true;

    }

    public static boolean checkUp(char[][] board,String word,int row,int col,int m,int n){

        int size=word.length();
        if(row+1<m && board[row+1][col]!='#') return false;
        if(row-size>=0 && board[row-size][col]!='#') return false;

        for(int i=0;i<size;i++){
            if(row-i<0) return false;
            if(board[row-i][col]==' ' || word.charAt(i)==board[row-i][col]) continue;
            else return false;
        }
        return true;
    }
    public static boolean solve(char[][] board,String word,int m,int n,int index){

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]!='#'){
                    if(checkLeft(board,word,i,j,m,n)) return true;
                    if(checkRight(board,word,i,j,m,n)) return true;
                    if(checkDown(board,word,i,j,m,n)) return true;
                    if(checkUp(board,word,i,j,m,n)) return true;
                }
            }
        }
        return false;
    }


    public static boolean placeWordInCrossword(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        return solve(board,word,m,n,0);
    }
}

public class CheckWordInCross {
    public static void main(String[] args) {

        char[][] board={
                {'#',' ','#'},
                {' ',' ','#'},
                {'#','c','#'}
        };

        String word="abc";
        System.out.println(Solution34.placeWordInCrossword(board,word));
    }
}
