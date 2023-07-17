package contest;
import java.util.Arrays;

public class DavidGoliath {
    private static final int LIMIT=(int)Math.pow(10,9)+7;
    public int helpDavid(int[] nums) {
        //your code here

        int n=nums.length;

        Arrays.sort(nums);
        long res=0,x=1;
        for(int i=0;i<n;i++){
            res=(res%LIMIT+nums[i]*x)%LIMIT;
            x=(x%LIMIT*2)%LIMIT;
        }

        long s=0;
        x=1;
        for(int i=n-1;i>=0;i--){
            s=(s%LIMIT+nums[i]*x)%LIMIT;
            x=(x%LIMIT*2)%LIMIT;
        }

        return (int)((res-s+LIMIT)%LIMIT);
    }
}

/*

  -4 3  1  3  9
  20 21 22 23 24


 */