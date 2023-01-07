import java.util.Arrays;
import java.util.Scanner;

class Frogs{
    public  static int jumps(int[] steps,int k){

        int[] dp=new int[steps.length];
        dp[0]=0;
        for(int i=1;i<steps.length;i++){
            int min_steps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int dist=dp[i-j]+Math.abs(steps[i]-steps[i-j]);
                    min_steps=Math.min(min_steps,dist);
                }
            }
            dp[i]=min_steps;
        }
        return dp[steps.length-1];
    }
}



public class FrogJumpKDistanceTabulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int k = sc.nextInt();
        int[] steps = new int[size];
        for (int i = 0; i < size; i++) {
            steps[i] = sc.nextInt();
        }
        int[] memo = new int[size];
        System.out.println(Frogs.jumps(steps, k));
    }
}
