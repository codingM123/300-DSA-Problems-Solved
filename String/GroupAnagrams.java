
import java.util.*;
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // key -> list of strings (signature by sorted chars)
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr); // sorted signature

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(input));
    }
}

/*
 Time: O(n * m log m) where m = average length of string (sorting)
 Space: O(n * m) for storing results
 Optimization note: For only lowercase letters, can use frequency signature (int[26]) to get O(n*m).
*/
