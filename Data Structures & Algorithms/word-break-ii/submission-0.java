class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (String k : wordDict) {
            set.add(k);
        }

        StringBuilder sb = new StringBuilder();

        solve(0, sb, s, set, ans);

        return ans;
    }

    private void solve(int idx, StringBuilder sb, String s, Set<String> set, List<String> ans) {
        if (idx >= s.length()) {
            ans.add(sb.toString().trim());
            return;
        }

        for (int i = idx; i < s.length(); i++) {

            if (set.contains(s.substring(idx, i + 1))) {
                String last = s.substring(idx, i + 1) + " ";
                sb.append(last);
                solve(i + 1, sb, s, set, ans);
                sb.delete(sb.length() - last.length(), sb.length());
            }
        }
    }
}