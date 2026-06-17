class Solution {
    public int minCostConnectPoints(int[][] points) {
        int i = 0, j = 0, ans = 0, n = points.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        List<int[]> edges = new ArrayList<>();

        for (i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                int dist  = Math.abs(points[i][0] - points[j][0]) + 
                            Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist, i, j});
            }
        }

        edges.sort((a, b) -> Integer.compare(a[0], b[0]));

        for (int[] edge : edges) {
            if (union(edge[1], edge[2], parent, size)) {
                ans += edge[0];
            }
        }

        return ans;
    }

    private int findParent(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findParent(parent[node], parent);
    }

    private boolean union(int u, int v, int[] parent, int[] size) {
        int up = findParent(u, parent);
        int vp = findParent(v, parent);

        if (up == vp) {
            return false;
        }

        if (size[up] < size[vp]) {
            parent[up] = vp;
            size[vp] += size[up];
        } else {
            parent[vp] = up;
            size[up] += size[vp];
        }

        return true;
    }
}
