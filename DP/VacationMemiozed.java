package DP;

import java.util.*;


public class VacationMemiozed{
    public static int lookUp(int day,int[][] paths,int lastTask,
                             int[][] memo){

        if(memo[day][lastTask]!=-1) return memo[day][lastTask];

        if(day==0){
            int mx=0;
            for(int i=0;i<3;i++){
                if(i!=lastTask) mx=Math.max(mx,paths[0][i]);
            }
            return mx;
        }

        int maxi=0;
        for(int i=0;i<3;i++){
            if(i!=lastTask){
                int point=paths[day][i]+lookUp(day-1,paths,i,memo);
                maxi=Math.max(maxi,point);
            }
        }

        memo[day][lastTask]=maxi;
        return maxi;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] paths=new int[n][3];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<3;j++){
                paths[i][j]=sc.nextInt();
            }
        }
        int lastTask=paths[0].length;
        int[][] memo=new int[paths.length][lastTask+1];
        for(int i=0;i<paths.length;i++){
            Arrays.fill(memo[i],-1);
        }
        System.out.println(lookUp(n-1,paths,lastTask,memo));
    }
}


//TC --> O(NX4)X3
//SC--->O(N)