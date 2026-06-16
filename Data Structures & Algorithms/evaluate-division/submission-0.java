class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int i = 0, j = 0;
        double[] res = new double[queries.size()];
        Map<String, List<Pair>> map = new HashMap<>();

        for (i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());

            map.get(a).add(new Pair(b, values[i]));
            map.get(b).add(new Pair(a, 1 / values[i]));
        }

        for (i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            res[i] = solve(src, target, map);
        }

        return res;
    }

    private double solve(String src, String target, Map<String, List<Pair>> map) {
        if (!map.containsKey(src) || !map.containsKey(target)) {
            return -1.0;
        }
        
        Queue<Pair> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        
        vis.add(src);
        q.add(new Pair(src, 1.0));

        while (!q.isEmpty()) {
            Pair top = q.poll();
            String node = top.node;
            double weight = top.weight;

            if (node.equals(target)) {
                return weight;
            }

            if (map.containsKey(node)) {
                for (Pair p : map.get(node)) {
                    if (!vis.contains(p.node)) {
                        vis.add(p.node);
                        q.add(new Pair(p.node, p.weight * weight));
                    }
                }
            }
        }

        return -1.0;
    }
}

public class Pair {
    String node;
    double weight;

    public Pair(String node, double weight) {
        this.node = node;
        this.weight = weight;
    }
}