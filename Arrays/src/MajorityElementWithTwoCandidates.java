import java.util.ArrayList;
import java.util.List;

public class MajorityElementWithTwoCandidates {

    List<Integer> majority(int[] nums) {
        int n = nums.length;
        List<Integer> l = new ArrayList<>();

        int candid1 = Integer.MAX_VALUE;
        int candid2 = Integer.MAX_VALUE;
        int count1 = 0, count2 = 0;


        for (int i = 0; i < n; i++) {
            if (nums[i] == candid1) count1++;
            else if (nums[i] == candid2) count2++;
            else if (count1 == 0) {
                candid1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candid2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }


        int c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candid1) c1++;
            if (nums[i] == candid2) c2++;
        }

        if (c1 > n / 3) l.add(candid1);
        if (c2 > n / 3) l.add(candid2);


        return l;
    }
}
