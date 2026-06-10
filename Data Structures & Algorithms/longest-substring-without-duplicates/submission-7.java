class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        s = s.replaceAll(" ", "");

        if (s.isEmpty()) {
            return 1;
        }

        int l = 0, res = 0, r = 0;
        char[] freq = new char[256];
        Set<Character> set = new HashSet<>();

        for (r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            
            while (set.contains(ch) && l < r) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(ch);
            res = Math.max(res, Math.abs(r - l) + 1);
        }
        
        return res;
    }
}
