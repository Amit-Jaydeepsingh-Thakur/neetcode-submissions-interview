class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();

        if (digits.isEmpty()) {
            return ans;
        }

        solve(0, "", digits, map, ans);
        return ans;
    }

    private void solve(int idx, String res, String digits, Map<Character, String> map, List<String> ans) {
        if (res.length() == digits.length()) {
            ans.add(res);
            return;
        }

        // System.out.println(digits.charAt(idx));
        String s = map.get(digits.charAt(idx));

        for (char ch : s.toCharArray()) {
            solve(idx + 1, res + ch, digits, map, ans);
        }
    }
}
