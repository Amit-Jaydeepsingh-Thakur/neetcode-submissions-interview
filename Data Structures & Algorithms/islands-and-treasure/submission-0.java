class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int i = 0, j = 0, n = grid.length, m = grid[0].length;

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (grid[i][j] == Integer.MAX_VALUE) {
                    grid[i][j] = solve(i, j, grid);
                }
            }
        }
    }

    private int solve(int i, int j, int[][] grid) {
        int path = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[grid.length][grid[0].length];
        q.add(new int[]{i, j});
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        vis[i][j] = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 1; k <= size; k++) {
                int[] top = q.poll();
                int x = top[0];
                int y = top[1];

                if (grid[x][y] == 0) {
                    return path;
                }
                
                for (int[] dir : dirs) {
                    int nR = x + dir[0];
                    int nC = y + dir[1];

                    if (nC >= 0 && nR >= 0 && nR < grid.length 
                        && nC < grid[0].length && grid[nR][nC] != -1 && vis[nR][nC] == 0) {
                        //grid[nR][nC] = -2;
                        vis[nR][nC] = 1;
                        q.add(new int[]{nR, nC});
                    }
                }
            }

            path++;
        }

        return Integer.MAX_VALUE;
    }
}
