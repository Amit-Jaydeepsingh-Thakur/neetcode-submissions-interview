class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int i = 0, j = 0;
        boolean[] dp = new boolean[s.length() + 1];
        boolean[] vis = new boolean[s.length() + 1];

        return solve(0, s, dp, vis, wordDict);
    }

    private boolean solve(int idx, String s, boolean[] dp, boolean[] vis, List<String> list) {

        if (idx == s.length()) {
            return true;
        }

        if (idx > s.length()) {
            return false;
        }

        if (vis[idx]) {
            return dp[idx];
        }

        for (int i = idx; i < s.length(); i++) {
            if (list.contains(s.substring(idx, i + 1))
                && solve(i + 1, s, dp, vis, list)) {
                vis[i] = true;
                return dp[i] = true;
            }
        }

        vis[idx] = true;
        return dp[idx] = false;
    }
}
