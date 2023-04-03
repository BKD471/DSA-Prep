package org.example.Day2;

public class OverlapCondition {
    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(A>=G || B>=H || C<=E || D<=F) return 0;
        return 1;
    }
}
