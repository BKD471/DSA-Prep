import java.util.Arrays;

public class MergeIntervalBestApproach {

        public int[][] merge(int[][] intervals) {

            int n=intervals.length;
            Arrays.sort(intervals,(a, b)-> Integer.compare(a[0],b[0]));


            int index=0;

            for(int i=1;i<n;i++){
                if(intervals[index][1]>=intervals[i][0]){
                    intervals[index][1]=Math.max(intervals[index][1],intervals[i][1]);
                }else{
                    index++;
                    intervals[index]=intervals[i];
                }
            }

            int[][] res=new int[index+1][2];
            for(int i=0;i<=index;i++){
                res[i]=intervals[i];
            }

            return res;
        }
}
