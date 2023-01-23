public class TownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] follower=new int[n];
        for(int i=0;i<trust.length;i++){
            int followerIndex=trust[i][0]-1;
            follower[followerIndex]=1;
        }

        int judge=-1;
        for(int i=0;i<n;i++){
            if(follower[i]==0) judge=i+1;
        }

        int cnt=0;
        for(int i=0;i<trust.length;i++){
            if(trust[i][1]==judge) cnt++;
        }
        return cnt==n-1? judge:-1;
    }
}
