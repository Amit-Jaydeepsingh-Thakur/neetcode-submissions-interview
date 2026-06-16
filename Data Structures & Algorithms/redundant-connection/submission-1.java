class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int i = 0, j = 0, n = edges.length;
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];

        for (i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1], parent, size)) {
                return edge;
            }
        }

        return new int[]{-1, -1};
    }
    
    private boolean union(int u, int v, int[] parent, int[] size) {
        int up = findParent(u, parent);
        int vp = findParent(v, parent);

        if (up == vp) {
            return false;
        }

        if (size[up] < size[vp]) {
            size[vp] += size[up];
            parent[up] = vp;
        } else {
            size[up] += size[vp];
            parent[vp] = up;
        }

        return true;
    }
    private int findParent(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findParent(parent[node], parent);
    }
}
