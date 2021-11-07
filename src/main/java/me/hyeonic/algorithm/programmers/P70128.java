package me.hyeonic.algorithm.programmers;

public class P70128 {

    public int solution(int[] a, int[] b) {

        int dotProduct = 0;
        for (int i = 0; i < a.length; i++) {
            dotProduct += a[i] * b[i];
        }

        return dotProduct;
    }

    public static void main(String[] args) {
        P70128 p70128 = new P70128();

        System.out.println(p70128.solution(new int[]{1,2,3,4}, new int[]{-3,-1,0,2}));
        System.out.println(p70128.solution(new int[]{-1,0,1}, new int[]{1,0,-1}));
    }
}