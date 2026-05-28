class Solution {
    public int numIslands(char[][] grid) {
        int i = 0, j = 0, ans = 0, n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && vis[i][j] != 1) {
                    dfs(i, j, grid, vis);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int i, int j, char[][] grid, int[][] vis) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || vis[i][j] == 1) {
            return;
        }

        vis[i][j] = 1;

        dfs(i + 1, j, grid, vis);
        dfs(i - 1, j, grid, vis);
        dfs(i, j + 1, grid, vis);
        dfs(i, j - 1, grid, vis);

        //vis[i][j] = 0;

    }
}
