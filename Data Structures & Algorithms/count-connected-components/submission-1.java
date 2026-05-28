class Solution {
    public int countComponents(int n, int[][] edges) {
        int i = 0, j = 0, ear = Integer.MIN_VALUE, ans = 0;
        int[] parent = new int[n];
        int[] size = new int[n];

        for (i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            unionBySize(edge[0], edge[1], parent, size);
        }

        Set<Integer> set = new HashSet<>();

        for (i = 0; i < n; i++) {
            set.add(findParent(i, parent, size));
        }

        return set.size();
    }

    private int findParent(int node, int[] parent, int[] size) {
        if (node == parent[node]) {
            return node;
        }

        int ulp = findParent(parent[node], parent, size);
        parent[node] = ulp;
        return parent[node];
    }

    private void unionBySize(int u, int v, int[] parent, int[] size) {
        if (u == v) {
            return;
        }

        int ulp = findParent(u, parent, size);
        int vlp = findParent(v, parent, size);

        if (size[ulp] < size[vlp]) {
            parent[ulp] = vlp;
            size[vlp] = size[ulp] + size[vlp];
        } else {
            parent[vlp] = ulp;
            size[ulp] = size[ulp] + size[vlp];
        }
    }
}
