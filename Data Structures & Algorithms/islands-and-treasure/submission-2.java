class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int i = 0, j = 0;

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == Integer.MAX_VALUE) {
                    //System.out.println("here ff" + " " + i + " " + j);
                    solve(i, j, grid);
                    // q.add(new int[]{i, j, 0});
                }
            }
        }
    }

    private void solve(int i, int j, int[][] grid) {
        //int dist = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        vis[i][j] = true;
        q.add(new int[]{i, j, 0});

        while (!q.isEmpty()) {
            int[] top = q.poll();

            int r = top[0];
            int c = top[1];
            int dist = top[2];

            if (grid[r][c] == 0) {
                grid[i][j] = dist;
                return;
            }

            for (int[] dir : dirs) {
                int x = r + dir[0];
                int y = c + dir[1];

                if (x >= 0 && y >= 0 && x < grid.length 
                    && y < grid[0].length && grid[x][y] != -1
                    && !vis[x][y]) {
                    q.add(new int[]{x, y, dist + 1});
                    vis[x][y] = true;
                }
            }
        }  
    }
}
