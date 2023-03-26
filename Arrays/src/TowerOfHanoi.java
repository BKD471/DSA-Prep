
public class TowerOfHanoi{

     int index=0;
     int[][] res;
    public void toh(int n,int A,int B,int C){
    
     if(n==0) return;
      toh(n-1,A,C,B);
      res[index][0]=n;
      res[index][1]=A;
      res[index][2]=C;
      index++;
      toh(n-1,B,A,C);
    }

    public int[][] towerOfHanoi(int n) {
        int size= (1<<n)-1;
        res=new int[size][3];
        toh(n,1,2,3);
        return res;
    }

}