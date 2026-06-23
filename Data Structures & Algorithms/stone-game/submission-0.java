class Solution {
    public boolean stoneGame(int[] piles) {
        int i = 0, j = 0, total = 0;
        int[][] dp = new int[piles.length][piles.length];

        for (i = 0; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        
        for (int ele : piles) {
            total += ele;
        }

        int alice = solve(0, piles.length - 1, piles, dp);

        //System.out.println(alice);

        return alice > total - alice;
        //return solve(0, 0, piles);
        
    }

    private int solve(int start, int end, int[] piles, int[][] dp) {
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        boolean flag = (end - start) % 2 == 0;
        int left = flag ? piles[start] : 0;
        int right = flag ? piles[end] : 0;

        return dp[start][end] = Math.max(solve(start + 1, end, piles, dp) + left, solve(start, end - 1, piles, dp) + right);
    }
}