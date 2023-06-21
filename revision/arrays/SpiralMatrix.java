package revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int r1=0,r2=m-1;
        int c1=0,c2=n-1;

        int maxDir=4,dir=0;
        List<Integer> res=new ArrayList<>();
        while(r1<=r2 && c1<=c2){

            dir%=maxDir;
            if(dir==0){
                for(int i=c1;i<=c2;i++){
                    res.add(matrix[r1][i]);
                }
                r1++;
            }
            else if(dir==1){
                for(int i=r1;i<=r2;i++){
                    res.add(matrix[i][c2]);
                }
                c2--;
            }else if(dir==2){
                for(int i=c2;i>=c1;i--){
                    res.add(matrix[r2][i]);
                }
                r2--;
            }else{
                for(int i=r2;i>=r1;i--){
                    res.add(matrix[i][c1]);
                }
                c1++;
            }
            dir++;
        }
        return res;
    }
}
