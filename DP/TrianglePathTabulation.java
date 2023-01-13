import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

class Solution22 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int n=triangle.get(m-1).size();
        int[][] dp=new int[m][n];

        for(int i=0;i<n;i++){
            dp[m-1][i]=triangle.get(m-1).get(i);
        }

        for(int i=m-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                int down=triangle.get(i).get(j)+dp[i+1][j];
                int down_right=triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(down,down_right);
            }
        }
        return dp[0][0];
    }
}


public class TrianglePathTabulation {
    public static void main(String[] args) {
       Integer[][] grids={{2},
                      {3,4},
                      {6,5,7},
                      {4,1,8,3}};
        List<List<Integer>> listOfGrids = Arrays.stream(grids)  //'array' is two-dimensional
                .map(Arrays::asList)
                .collect(Collectors.toList());
        System.out.println(Solution22.minimumTotal(listOfGrids));
    }
}
