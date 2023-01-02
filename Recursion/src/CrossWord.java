import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'crosswordPuzzle' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY crossword
     *  2. STRING words
     */

    public static boolean insertVertically(int row,int col,char[][] board,String[] searchTask,boolean[][] visited,int index){

        int letterCount=0;
        int temp_row=row;
        for(int i=0;i<searchTask[index].length();i++){
            if(temp_row>=10) return false;
            if(board[temp_row][col]=='-') letterCount++;
            else if(board[temp_row][col]==searchTask[index].charAt(i)) letterCount++;
            else if(board[temp_row][col]=='+') return false;
            temp_row++;
        }

        temp_row=row;
        if(letterCount==searchTask[index].length()){
            for(int i=0;i<searchTask[index].length();i++){
                if(board[temp_row][col]=='-') {
                    board[temp_row][col]=searchTask[index].charAt(i);
                    visited[index][i]=true;
                }
                temp_row++;
            }
            return true;
        }

        return false;
    }

    public static boolean insertHorizontally(int row,int col,char[][] board,String[] searchTask,boolean[][] visited,int index){

        int letterCount=0;
        int temp_col=col;
        for(int i=0;i<searchTask[index].length();i++){
            if(temp_col>=10) return false;
            if(board[row][temp_col]=='-') letterCount++;
            else if(board[row][temp_col]==searchTask[index].charAt(i)) letterCount++;
            else if(board[row][temp_col]=='+') return false;
            temp_col++;
        }

        temp_col=col;
        if(letterCount==searchTask[index].length()){
            for(int i=0;i<searchTask[index].length();i++){
                if(board[row][temp_col]=='-') {
                    board[row][temp_col]=searchTask[index].charAt(i);
                    visited[index][i]=true;
                }
                temp_col++;
            }
            return true;
        }

        return false;
    }


    public static  void removeVertically(int row,int col,char[][] board,String[] searchTask,boolean[][] visited,int index){

        String word=searchTask[index];
        for(int i=0;i<word.length();i++){
            if(visited[index][i]){
                board[row][col]='-';
                visited[index][i]=false;
            }
            row++;
        }
    }

    public static void removeHorizontally(int row,int col,char[][] board,String[] searchTask,boolean[][] visited,int index){

        String word=searchTask[index];
        for(int i=0;i<word.length();i++){
            if(visited[index][i]){
                board[row][col]='-';
                visited[index][i]=false;
            }
            col++;
        }
    }

    public static void solve(List<String> res,char[][] board,String[] searchTask,boolean[][] visited,int index){

        if(index==searchTask.length){
            for(int i=0;i<10;i++){
                String s="";
                for(int j=0;j<10;j++){
                    s+=board[i][j];
                }
                res.add(s);
            }
            return;
        }
        boolean flag=false;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(board[i][j]=='-' || board[i][j]==searchTask[index].charAt(0))
                {
                    flag=insertVertically(i,j,board,searchTask,visited,index);
                    if(flag) solve(res,board,searchTask,visited,index+1);
                    if(flag) removeVertically(i,j,board,searchTask,visited,index);

                    flag=insertHorizontally(i,j,board,searchTask,visited,index);
                    if(flag) solve(res,board,searchTask,visited,index+1);
                    if(flag) removeHorizontally(i,j,board,searchTask,visited,index);
                }
            }
        }
    }

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
        // Write your code here]
        List<String> res=new ArrayList<>();
        String[] searchTask=words.split(";");
        char[][] board=new char[10][10];

        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                board[i][j]=crossword.get(i).charAt(j);
            }
        }

        boolean[][] visited=new boolean[searchTask.length][];
        for(int i=0;i<searchTask.length;i++){
            visited[i]=new boolean[searchTask[i].length()];
        }

        solve(res,board,searchTask,visited,0);
        return res;
    }

}

public class CrossWord {
    public static void main(String[] args) {

        List<String> crosswords=new ArrayList<>();
        crosswords.add("++++++++++");
        crosswords.add("+------+++");
        crosswords.add("+++-++++++");
        crosswords.add("+++-++++++");
        crosswords.add("+++-----++");
        crosswords.add("+++-++-+++");
        crosswords.add("++++++-+++");
        crosswords.add("++++++-+++");
        crosswords.add("++++++-+++");
        crosswords.add("++++++++++");
        String words="POLAND;LHASA;SPAIN;INDIA";

        List<String> res=Result.crosswordPuzzle(crosswords,words);
        res.forEach(t-> System.out.println(t));
    }
}
