package JavaHW5;


import java.util.HashMap;

public class Ex2085 {
    public static void main(String[] args) {
        String[] words1 = new String[]{"b", "bb", "bbb"};
        String[] words2 = new String[]{"a", "aa", "aaa"};

        System.out.println(countWords(words1, words2));
    }

    public static int countWords(String[] words1, String[] words2) {
        if (words1.length > words2.length) {
            return countWords(words2, words1);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            if (map.containsKey(word)) {
                if (map.get(word) <= 1) {
                    map.put(word, map.get(word) - 1);
                }
            }
        }

        int ans = 0;

        for (String word : words1) {
            if (map.get(word) == 0) {
                ans += 1;
            }
        }
        return ans;
    }
}

/*class Solution {
    public int countWords(String[] words1, String[] words2) {
     
        int count = 0;
        
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        for(String s : words1)
            map.put(s,map.getOrDefault(s,0)+1);
        
        for(String s : words2)
            map2.put(s,map2.getOrDefault(s,0)+1);
        
        for(String s : words1)
            if(map.get(s) == 1 && map2.containsKey(s))
                if(map2.get(s) == 1)
                count++;
        
        return count;
        
    }
}
//https://leetcode.com/problems/count-common-words-with-one-occurrence/
