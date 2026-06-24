class Solution {
    public int numDistinct(String s, String t) {
        int i = 0, j = 0;
        int[][] dp = new int[s.length()][t.length()];

        for (i = 0; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, s, t, dp);
        
    }

    private int solve(int i, int j, String s, String t, int[][] dp) {
        if (j == t.length()) {
            return 1;
        }
        
        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = solve(i + 1, j, s, t, dp);
        if (s.charAt(i) == t.charAt(j)) {
            ans += solve(i + 1, j + 1, s, t, dp);
        } 

        return dp[i][j] = ans;
    }
}
