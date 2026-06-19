class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        return solve(0, s, dp);
        
    }

    private int solve(int idx, String s, int[] dp) {
        if (idx == s.length()) {
            return dp[idx] = 1;
        }

        if (idx > s.length() || s.charAt(idx) == '0') {
            return 0;
        }

        if (dp[idx] != Integer.MAX_VALUE) {
            return dp[idx];
        }

        int ans = solve(idx + 1, s, dp);

        if (idx + 1 < s.length()) {
            int dig = Integer.parseInt(s.substring(idx, idx + 2));

            if (dig >= 10 && dig <= 26) {
                ans += solve(idx + 2, s, dp);
            }
        }

        return dp[idx] = ans;


    }
}
