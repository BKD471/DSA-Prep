package BinarySearch;

public class HindexLC275 {
    public int h(int citations[]){
        int n=citations.length;
        int l=0,h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(citations[mid]==(n-mid)) return citations[mid];
            if(citations[mid]>(n-mid)) h=mid-1;
            else l=mid+1;
        }
        return n-l;
    }
}
