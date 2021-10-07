//https://programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;

class Solution {
    List<String> wordList = new ArrayList<>();

    public int changeWord(String word, String target, int size, String[] words) {
        for (String w : words) {
            char[] wordArray = word.toCharArray();
            char[] wArray = w.toCharArray();
            int cnt = 0;
            for (int i = 0; i < size; i++) {
                if (cnt > 1) {
                    break;
                } else {
                    if (wordArray[i] != wArray[i]) {
                        cnt++;
                    }
                }
            }
            if (cnt == 1) {
                if (w.equals(target)) {
                    return 1;
                }
                wordList.add(w);
            }
        }

        return 0;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        int in = 0;
        for (String w : words) {
            if (w.equals(target)) {
                in = 1;
                break;
            }
        }

        if (in == 0) {
            return 0;
        }

        int size = begin.length();
        int max = words.length;

        wordList.add(begin);
        int find = 0;
        for (int i = 0; i < max; i++) {
            int listSize = wordList.size();
            for (int s = 0; s < listSize; s++) {
                String word = wordList.get(0);
                find = changeWord(word, target, size, words);
                wordList.remove(0);
            }
            answer++;
            if (find == 1) {
                break;
            }
        }

        if (find != 1) {
            return 0;
        }

        return answer;
    }
}