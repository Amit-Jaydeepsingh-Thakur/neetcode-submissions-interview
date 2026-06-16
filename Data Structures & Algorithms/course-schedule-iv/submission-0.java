class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int i = 0, j = 0, k = 0, n = numCourses;
        List<Boolean> ans = new ArrayList<>();
        boolean[][] reachable = new boolean[n][n];

        for (int[] pre : prerequisites) {
            reachable[pre[0]][pre[1]] = true;
        }

        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        for (int[] query : queries) {
            ans.add(reachable[query[0]][query[1]]);
        }

        return ans;
    }
}