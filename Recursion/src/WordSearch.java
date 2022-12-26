import java.util.Arrays;
class Solution15 {
    public static boolean solve(char[][] board,boolean[][] visited,
                         String word,String temp,int row,int col,int m,int n,int len,int index){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)
                        && lookUp(i,j,word,board,visited,1,len,m,n))
                    return true;
            }
        }
        return false;
    }

    public static boolean lookUp(int row,int col,String word,
                          char[][] board,boolean[][] visited,int index,int len,int m,int n){
        if(index==len){

            return true;
        }

        //UP
        if(row>0 && !visited[row-1][col] && board[row-1][col]==word.charAt(index)){
            visited[row][col]=true;
            if(lookUp(row-1,col,word,board,visited,index+1,len,m,n)==true) return true;
            else visited[row][col]=false;
        }

        //DOWN
        if(row<m-1 && !visited[row+1][col] && board[row+1][col]==word.charAt(index)){
            visited[row][col]=true;
            if(lookUp(row+1,col,word,board,visited,index+1,len,m,n)==true)return true;
            else visited[row][col]=false;
        }

        //Right
        if(col<n-1 && !visited[row][col+1] && board[row][col+1]==word.charAt(index)){
            visited[row][col]=true;
            if(lookUp(row,col+1,word,board,visited,index+1,len,m,n)==true) return true;
            else visited[row][col]=false;
        }

        //Left
        if(col>0 && !visited[row][col-1] && board[row][col-1]==word.charAt(index)){
            visited[row][col]=true;
            if(lookUp(row,col-1,word,board,visited,index+1,len,m,n)==true) return true;
            else visited[row][col]=false;
        }

        return false;
    }

    public static boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        boolean visited[][]=new boolean[row][col];


        for(boolean[] temp:visited){
            Arrays.fill(temp,false);
        }
        int n=word.length();
        return solve(board,visited,word,"",0,0,row,col,n,0);
    }
}






public class WordSearch {
    public static void main(String[] args) {
        char[][] board={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(Solution15.exist(board,"ABCCED"));
    }
}
