package revision.arrays;

class SumOfAllSubArrays{
    public long contribution(int[] A) {
        int n=A.length;
        long res=0;
        for(int i=0;i<n;i++){
            long start=i+1;
            long end=n-i;
            res+=(A[i]*start*end);
        }
        return res;
    }
}