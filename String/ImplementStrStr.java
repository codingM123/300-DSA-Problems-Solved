
public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        return kmpSearch(haystack, needle);
    }

    private static int kmpSearch(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if (j == m) return i - j; // match found
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
