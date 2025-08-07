package Day6;

import java.util.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, ans = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            ans = Math.max(ans, set.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
