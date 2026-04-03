public class Solution {
    public boolean isAnagram(String s, String t) {
        // Step 1: Quick check - different lengths can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Count letters in first string
        int[] count = new int[26]; // Only lowercase a-z (26 letters)

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++; // 'a'->0, 'b'->1, etc.
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            count[ch - 'a']--; // SUBTRACT instead of add!
        }

        // Step 4: Check if all counts are zero
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false; // Not an anagram!
            }
        }
        return true;
    }
}