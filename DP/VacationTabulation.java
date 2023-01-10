import java.util.Scanner;

class Solve12 {
    public static int lookUp(int[][] paths,int n){

        int[][] dp=new int[n][4];
        dp[0][0]=Math.max(paths[0][1],paths[0][2]);
        dp[0][1]=Math.max(paths[0][0],paths[0][2]);
        dp[0][2]=Math.max(paths[0][1],paths[0][0]);
        dp[0][3]=Math.max(paths[0][0],Math.max(paths[0][1],paths[0][2]));


        for(int day=1;day<n;day++){
            for(int lastTask=0;lastTask<4;lastTask++){
                dp[day][lastTask]=0;
                // we have only thress tasks to perform
                for(int task=0;task<3;task++){
                    if(task!=lastTask){
                        int points=paths[day][task]+dp[day-1][task];
                        dp[day][lastTask]=Math.max(dp[day][lastTask],points);
                    }
                }
            }

        }

        return dp[n-1][3];
    }
}


public class VacationTabulation {
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

        System.out.println(Solve12.lookUp(paths,n));
    }
}
