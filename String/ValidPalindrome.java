
public class Q2_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            // move i forward to next alnum
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if (i < j) {
                char a = Character.toLowerCase(s.charAt(i));
                char b = Character.toLowerCase(s.charAt(j));
                if (a != b) return false;
                i++; j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
    }
}
