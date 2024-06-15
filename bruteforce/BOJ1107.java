package bruteforce;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1107
public class BOJ1107 {
    static boolean[] nums = new boolean[10];
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        Arrays.fill(nums, true);
        // M이 0일 때 입력받는 값이 없는 것 주의하기
        if(M != 0) {
            for (int i = 0; i < M; i++) {
                nums[Integer.parseInt(token.nextToken())] = false;
            }
        }
        if(N == 100) {
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(min, Math.abs(N-100));

        for(int i = 0; i <= 1000000; i++) {
            String num = String.valueOf(i);
            if(canButtonPush(num)) {
                min = Math.min(min, num.length()+Math.abs(i-N));
            }
        }
        System.out.println(min);
    }
    static boolean canButtonPush(String n) {
        for(int i = 0; i < 10; i++) {
            if(!nums[i] && n.contains(String.valueOf(i)))
                return false;
        }
        return true;
    }
}
