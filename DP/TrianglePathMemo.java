import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution25 {
    public static int lookUp(List<List<Integer>> triangle, int[][] memo, int row, int col, int m){

        if(row==m-1){
            return triangle.get(row).get(col);
        }


        if(memo[row][col]!=-1) return memo[row][col];

        //down
        int down=triangle.get(row).get(col)+lookUp(triangle,memo,row+1,col,m);


        //south east
        int south_east=triangle.get(row).get(col)+lookUp(triangle,memo,row+1,col+1,m);

        memo[row][col]=Math.min(south_east,down);
        return memo[row][col];
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int n=triangle.get(m-1).size();
        int[][] memo=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return lookUp(triangle,memo,0,0,m);
    }
}

public class TrianglePathMemo {
    public static void main(String[] args) {
        Integer[][] grids={
                {2},
                {3,4},
                {5,6,7},
                {4,1,8,3}
        };

        List<List<Integer>> gridList=Arrays.stream(grids).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(Solution25.minimumTotal(gridList));
    }
}
