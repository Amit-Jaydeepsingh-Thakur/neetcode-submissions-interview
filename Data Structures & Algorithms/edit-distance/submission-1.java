class Solution {
    public int minDistance(String word1, String word2) {
        int i = 0, j = 0;
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (i = 0; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, word1, word2, dp);
    }

    private int solve(int i, int j, String word1, String word2, int[][] dp) {
        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, word1, word2, dp);
        } else {
            return dp[i][j] = 1 + Math.min(solve(i + 1, j, word1, word2, dp), 
                Math.min(solve(i, j + 1, word1, word2, dp), solve(i + 1, j + 1, word1, word2, dp)));
        }
    }
}
