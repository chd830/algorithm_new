package greedy;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2839
public class BOJ2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[5001];
        Arrays.fill(arr, -1);
        arr[3] = 1;
        arr[5] = 1;
        for(int i = 6; i <= N; i++) {
            if(i%3 == 0)
                arr[i] = arr[i%3]+1;
            if(i%5 == 0)
                arr[i] = arr[i%5]+1;
            if(arr[i-3] != -1)
                arr[i] = arr[i-3]+1;
            if(arr[i-5] != -1)
                arr[i] = arr[i-5]+1;
        }
        System.out.println(arr[N]);
    }
}
