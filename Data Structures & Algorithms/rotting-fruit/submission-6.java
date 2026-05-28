class Solution {
    public int orangesRotting(int[][] grid) {
        int i = 0, j = 0, fresh = 0, time = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] vis = new int[grid.length][grid[0].length];

        for (i = 0 ; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 1;
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();

            for (int k = 1; k <= size; k++) {
                int[] top = q.poll();

                int x = top[0];
                int y = top[1];

                for (int[] dir : dirs) {
                    int nR = x + dir[0];
                    int nC = y + dir[1];

                    if (nR < 0 || nC < 0 || nR >= grid.length 
                        || nC >= grid[0].length || grid[nR][nC] != 1 || vis[nR][nC] == 1) {
                        continue;
                    }

                    fresh--;
                    vis[nR][nC] = 1;
                    q.add(new int[]{nR, nC});
                }
            }
            time++;
        }

        return (fresh == 0) ? time : -1;
        
    }
}
