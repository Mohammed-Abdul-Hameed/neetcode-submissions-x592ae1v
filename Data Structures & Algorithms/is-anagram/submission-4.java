class Solution {
    public boolean isAnagram(String s, String t) {
        // size of both the strings doesnt match return false
        if (s.length() != t.length())
            return false;

        // initialise the frequency array[26]
        int[] freq = new int[26];

        // Loop
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++; // deposit s
            freq[t.charAt(i) - 'a']--; // withdraw t (same loop!)
        }

        for (int count : freq)
            if (count != 0)
                return false;

        return true;
    }
}
