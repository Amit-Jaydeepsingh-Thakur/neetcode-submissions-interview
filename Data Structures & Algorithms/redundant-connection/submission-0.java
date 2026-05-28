class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int i = 0, j = 0, n = edges.length;
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];

        for (i = 0 ; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (!unionBySize(edge[0], edge[1], parent, size)) {
                return edge;
            }
        }

        return new int[]{-1, -1};
    }

    private int findParent(int node, int[] parent, int[] size) {
        if (parent[node] == node) {
            return node;
        }

        int ulp = findParent(parent[node], parent, size);
        parent[node] = ulp;
        return ulp;
    }

    private boolean unionBySize(int u, int v, int[] parent, int[] size) {
        int ulp = findParent(u, parent, size);
        int vlp = findParent(v, parent, size);

        if (vlp == ulp) {
            return false;
        }

        if (size[ulp] < size[vlp]) {
            parent[ulp] = vlp;
            size[vlp] = size[ulp] + size[vlp];
        } else {
            parent[vlp] = ulp;
            size[ulp] = size[ulp] + size[vlp];
        }

        return true;
    }
}
