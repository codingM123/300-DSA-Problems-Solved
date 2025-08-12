
import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int haveCount = 0, needCount = need.size();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                haveCount++;
            }

            while (haveCount == needCount) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    haveCount--;
                }
                left++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // "BANC"
    }
}

/*
 Time: O(n)
 Space: O(k) — k = distinct chars in s/t
*/
