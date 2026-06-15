class Solution {
    public int islandPerimeter(int[][] grid) {
        int i = 0, j = 0, flag = 0;
        int[] ans = new int[1];

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    solve(i, j, grid, ans);
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                break;
            }
        }

        return ans[0];
    }

    private void solve(int i, int j, int[][] grid, int[] ans) {
        if( i < 0 || j < 0 
            || i >= grid.length || j >= grid[0].length
            || grid[i][j] == 0) {
                ans[0]++;
                return;
            }
        
        if (grid[i][j] == 2) {
            return;
        }

        int org = grid[i][j];
        grid[i][j] = 2;

        solve(i + 1, j, grid, ans);
        solve(i - 1, j, grid, ans);
        solve(i, j + 1, grid, ans);
        solve(i, j - 1, grid, ans);

        //grid[i][j] = org;

        return;
    }
}