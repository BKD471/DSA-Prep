import java.util.ArrayList;


public class Rearrange {
    public void arrange(ArrayList<Integer> A) {
        int n=A.size();

        for(int i=0;i<n;i++){
            int t=A.get(i)+(((A.get(A.get(i)))%n)*n);
            A.set(i,t);
        }

        for(int i=0;i<n;i++){
            int t=A.get(i)/n;
            A.set(i,t);
        }

    }
}
