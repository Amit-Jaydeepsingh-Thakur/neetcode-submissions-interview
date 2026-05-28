class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int i = 0, j = 0, ans = 0;
        int[][] vis = new int[grid.length][grid[0].length];

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    ans = Math.max(ans, solve(i, j, grid, vis));
                }
            }
        }

        return ans;
    }

    private int solve(int i, int j, int[][] grid, int[][] vis) {
        int area = 1;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        q.add(new int[]{i, j});
        grid[i][j] = 0;

        while (!q.isEmpty()) {
            int[] top = q.poll();

            int x = top[0];
            int y = top[1];

            for (int[] dir : dirs) {
                int nR = x + dir[0];
                int nC = y + dir[1];

                if (nR >= 0 && nC >= 0 && nR < grid.length 
                    && nC < grid[0].length && grid[nR][nC] == 1) {
                    area++;
                    grid[nR][nC] = 0;
                    q.add(new int[]{nR, nC});
                }  
            }
        }

        return area;
    }
}
