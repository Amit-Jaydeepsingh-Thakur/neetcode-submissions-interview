class Solution {
    public int orangesRotting(int[][] grid) {
        int i = 0, j = 0, fresh = 0, level = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if (fresh == 0) {
            return level;
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (i = 1; i <= size; i++) {
                int[] top = q.poll();

                int r = top[0];
                int c = top[1];

                for (int[] dir : dirs) {
                    int x = r + dir[0];
                    int y = c + dir[1];

                    if (x >= 0 && y >= 0 
                        && x < grid.length && y < grid[0].length
                        && grid[x][y] == 1) {
                            grid[x][y] = 2;
                            fresh--;
                            q.add(new int[]{x, y});
                        }
                }
            }

            level++;
        }

        return (fresh == 0 ? level - 1 : -1);
    }
}
