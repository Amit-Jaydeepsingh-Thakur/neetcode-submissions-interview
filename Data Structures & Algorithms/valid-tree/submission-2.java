class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        int i = 0, j = 0;
        int[] parent = new int[n];
        int[] size = new int[n];

        for (i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (!unionBySize(edge[0], edge[1], parent, size)) {
                return false;
            }
        }

        return true;

    }

    private int findParent(int u, int[] parent) {
        if (u == parent[u]) {
            return u;
        }

        return parent[u] = findParent(parent[u], parent);
    }

    private boolean unionBySize(int u, int v, int[] parent, int[] size) {
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
