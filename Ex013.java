package JavaHW5;

import java.util.HashMap;

public class Ex013 {
    public static void main(String[] args) {
        String s = "MCMXXXV";
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int res = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                res = res - roman.get(s.charAt(i));
            }
            else {
                res = res + roman.get(s.charAt(i));
            }
        }
        return res + roman.get(s.charAt(s.length() - 1));
    }
}


/*class Solution
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I' && i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')){
                sum -= map.get(s.charAt(i));
            }else if(s.charAt(i) == 'X' && i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')){
                sum -= map.get(s.charAt(i));
            }else if(s.charAt(i) == 'C' && i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')){
                sum -= map.get(s.charAt(i));
            }else{
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}

//https://leetcode.com/problems/roman-to-integer/
