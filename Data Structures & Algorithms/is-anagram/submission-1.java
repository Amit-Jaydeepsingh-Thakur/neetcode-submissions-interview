class Solution {
    public boolean isAnagram(String s, String t) {
        int i = 0;
        char[] freq = new char[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }

        for (i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;

    }
}
