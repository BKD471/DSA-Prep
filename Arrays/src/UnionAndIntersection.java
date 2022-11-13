import java.util.ArrayList;
import java.util.Arrays;

public class UnionAndIntersection extends Utility {

    public ArrayList<Integer> interSection(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> intersectionList = new ArrayList<>();

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums2[j] < nums1[i]) j++;
            else {
                intersectionList.add(nums1[i]);

                int l=nums1[i];
                while(i<n && l==nums1[i]) i++;

                int r=nums2[j];
                while(j<m && r==nums2[j]) j++;
            }
        }
        return intersectionList;
    }

    public ArrayList<Integer> union(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> unionList = new ArrayList<>();

        if (m < n) return union(nums2, nums1);


        for (int i = 0; i < n; i++) {
            int v=nums1[i];
            while(i<n-1 && v==nums1[i+1]) i++;
            unionList.add(nums1[i]);
        }

        for (int i = 0; i < m; i++) {
            if (binarySearch(nums1, nums2[i]) == -1) {
                unionList.add(nums2[i]);
            }
            int v=nums2[i];
            while(i<m-1 && nums2[i+1]==v) i++;
        }
        return unionList;
    }
}
