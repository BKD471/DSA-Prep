package DP;

public class WordSearch {
        private boolean checkWords(char[][] board,boolean[][] vis,int r,int c,int size,String word,int m,int n,int index){
            if(r>=board.length || c>=board[0].length || r<0 || c<0) return false;
            if(index>=size) return true;
            //down
            if(r+1<m  && !vis[r+1][c] && board[r+1][c]==word.charAt(index)) {
                vis[r][c]=true;
                if(checkWords(board, vis, r + 1, c, size, word, m, n, index + 1)) return true;
                vis[r][c]=false;
            }

            //up
            if(r>0 && !vis[r-1][c] && board[r-1][c]==word.charAt(index)){
                vis[r][c]=true;
                if(checkWords(board,vis,r-1,c,size,word,m,n,index+1)) return true;
                vis[r][c]=false;
            }

            //left
            if(c>0 && !vis[r][c-1] && board[r][c-1]==word.charAt(index)){
                vis[r][c]=true;
                if(checkWords(board,vis,r,c-1,size,word,m,n,index+1)) return true;
                vis[r][c]=false;
            }

            //right
            if(c+1<n && !vis[r][c+1] && board[r][c+1]==word.charAt(index)){
                vis[r][c]=true;
                if(checkWords(board,vis,r,c+1,size,word,m,n,index+1)) return true;
                vis[r][c]=false;
            }
            return false;
        }

        public boolean exist(char[][] board, String word) {
            int m=board.length,n=board[0].length;
            boolean[][] vis=new boolean[m][n];


            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]==word.charAt(0) && checkWords(board,vis,i,j,word.length(),word,m,n,1)) return true;
                }
            }
            return false;
        }
}
