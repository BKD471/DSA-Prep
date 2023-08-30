package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutation {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    private void swap(ArrayList<Integer> tmp, int l, int h) {
        int t = tmp.get(l);
        tmp.add(l, tmp.get(h));
        tmp.add(h, t);
    }

    private void printPermutation(ArrayList<Integer> arr, int index) {
        if (index >= arr.size()) {
            res.add(new ArrayList<>(arr));
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            Collections.swap(arr, i, index);
            printPermutation(arr, i + 1);
            Collections.swap(arr, i, index);
        }
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> arr) {
        printPermutation(arr, 0);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        ArrayList<ArrayList<Integer>> op = new Permutation().permute(arr);
        System.out.println(op);
    }
}
