package revision.arrays;

import java.util.ArrayList;

public class SearchElementInThreeSorted {


    public static ArrayList<Integer> findCommonElements(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = a.size();
        int n = b.size();
        int o = c.size();


        int i = 0, j = 0, k = 0;
        while (i < m && j < n && k < o) {
            int f = a.get(i);
            int g = b.get(j);
            int h = c.get(k);

            if ((f == g) && (g == h)) {
                res.add(g);

                while (i < m && f == a.get(i)) i++;
                while (j < n && g == b.get(j)) j++;
                while (k < o && h == c.get(k)) k++;

            } else if (f < g) i++;
            else if (g < h) j++;
            else k++;
        }
        return res;
    }

}
