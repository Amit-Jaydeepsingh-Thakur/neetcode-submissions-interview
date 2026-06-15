class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int i = 0, j = 0, res = 0;

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int ans = solve(i, j, grid);
                    res = Math.max(ans, res);
                }
            }
        }

        return res;
    }

    private int solve(int i, int j, int[][] grid) {
        int area = 1;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        q.add(new int[]{i, j});
        grid[i][j] = 2;

        while (!q.isEmpty()) {
            int[] top = q.poll();

            int r = top[0];
            int c = top[1];

            for (int[] dir : dirs) {
                int x = r + dir[0];
                int y = c + dir[1];
                
                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                && grid[x][y] == 1) {
                    area++;
                    grid[x][y] = 2;
                    q.add(new int[]{x, y});
                }

            }
        }

        return area;
    }
}
