class Solution {
    public int numIslands(char[][] grid) {
        int i = 0, j = 0, ans = 0;

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    solve(i, j, grid);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void solve(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length 
            || grid[i][j] == '*' || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '*';

        solve(i + 1, j, grid);
        solve(i - 1, j, grid);
        solve(i, j + 1, grid);
        solve(i, j - 1, grid);
    }
}
