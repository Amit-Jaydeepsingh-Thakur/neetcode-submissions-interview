class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = 0, j = 0;
        int[][] dp = new int[text1.length()][text2.length()];

        for (i = 0; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, text1, text2, dp);
    }

    private int solve(int i, int j, String s1, String s2, int[][] dp) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + solve(i + 1, j + 1, s1, s2, dp);
        }

        return dp[i][j] = Math.max(solve(i + 1, j, s1, s2, dp), solve(i, j + 1, s1, s2, dp));
    }
}
