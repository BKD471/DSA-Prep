import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixI {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int m=matrix.length;
        if(m==0) return res;
        int n=matrix[0].length;

        int begRow=0,endRow=m-1;
        int begCol=0,endCol=n-1;
        int dir=0,maxDir=4;

        while(begRow<=endRow && begCol<=endCol){

            dir=dir%maxDir;
            if(dir==0){
                for(int i=begCol;i<=endCol;i++){
                    res.add(matrix[begRow][i]);
                }
                begRow++;
            }

            if(dir==1){
                for(int i=begRow;i<=endRow;i++){
                    res.add(matrix[i][endCol]);
                }
                endCol--;
            }


            if(dir==2){
                for(int i=endCol;i>=begCol;i--){
                    res.add(matrix[endRow][i]);
                }
                endRow--;
            }

            if(dir==3){
                for(int i=endRow;i>=begRow;i--){
                    res.add(matrix[i][begCol]);
                }
                begCol++;
            }

            dir++;
        }

        return res;

    }
}
