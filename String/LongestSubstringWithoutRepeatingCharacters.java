
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        // map char -> last index + 1 (to avoid re-check)
        int[] last = new int[256]; // ASCII cover, initialized to 0
        int maxLen = 0, start = 0; // start is window start (inclusive)

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // last[c] stores index+1 of last occurrence; move start if seen inside window
            start = Math.max(start, last[c]);
            maxLen = Math.max(maxLen, i - start + 1);
            last[c] = i + 1; // store position +1
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3 ("wke")
    }
}

/*
 Time: O(n)
 Space: O(1) — fixed 256 array
