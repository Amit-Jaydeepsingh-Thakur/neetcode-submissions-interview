class Solution {
    public int findJudge(int n, int[][] trust) {
        int i = 0, j = 0;
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];

            indegree[b]++;
            outdegree[a]++;
        }

        for (i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;  
    }
}