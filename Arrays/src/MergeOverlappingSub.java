import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingSub {
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));
        Stack<int[]> stack=new Stack<>();

        for(int[] interval:intervals){
            if(stack.empty() || stack.peek()[1]<interval[0]) stack.push(interval);
            else stack.peek()[1]=Math.max(stack.peek()[1],interval[1]);
        }
        return stack.toArray(new int[stack.size()][]);
    }
}
