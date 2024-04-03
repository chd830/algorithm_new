package KMP;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1259
public class BOJ1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        loop: while(!"0".equals(str = br.readLine())) {
            int len = str.length();

            for(int i = 0; i < len; i++) {
                if(str.charAt(i) != str.charAt(len-1-i)) {
                    System.out.println("no");
                    continue loop;
                }
            }
            System.out.println("yes");
        }
    }
}
