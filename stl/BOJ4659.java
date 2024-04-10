package stl;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/4659
public class BOJ4659 {
    static String SUCCESS = " is acceptable.\n";
    static String FAIL = " is not acceptable.\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        loop: while(!"end".equals(str = br.readLine())) {
            // 자음 consonants 모음 vowels
            boolean isContains = false;
            char prev = ' ';
            Queue<Boolean> consonants = new LinkedList<>();
            Queue<Boolean> vowels = new LinkedList<>();
            for(char c : str.toCharArray()) {
                switch (c) {
                    case 'a': case 'e': case 'i': case 'o': case 'u':
                        isContains = true;
                        if(!consonants.isEmpty() && consonants.size() >= 3) {
                            sb.append("<").append(str).append(">").append(FAIL);
                            continue loop;
                        }
                        else {
                            consonants.clear();
                            vowels.add(true);
                        }
                        break;
                    default:
                        if(!vowels.isEmpty() && vowels.size() >= 3) {
                            sb.append("<").append(str).append(">").append(FAIL);
                            continue loop;
                        }
                        else {
                            vowels.clear();
                            consonants.add(true);
                        }
                        break;
                }
                if(prev != 'e' && prev != 'o' && c == prev) {
                    sb.append("<").append(str).append(">").append(FAIL);
                    continue loop;
                }
                prev = c;
            }
            if(!consonants.isEmpty() && consonants.size() >= 3 || !vowels.isEmpty() && vowels.size() >= 3 || !isContains)
                sb.append("<").append(str).append(">").append(FAIL);
            else
                sb.append("<").append(str).append(">").append(SUCCESS);

        }
        System.out.println(sb);
    }
}
