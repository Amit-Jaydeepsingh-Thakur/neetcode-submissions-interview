class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int i = 0, j = 0, ans = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        boolean[] vis = new boolean[n + 1];
        int[] dist = new int[n + 1];

        for (i = 1; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int[] time : times) {
            int x = time[0];
            int y = time[1];
            int weight = time[2];

            map.computeIfAbsent(x, m -> new ArrayList<>()).add(new int[]{y, weight});
        }

        dist[k] = 0;
        vis[k] = true;
        q.add(new int[]{0, k});
        
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int weight = top[0];
            int p = top[1];

            //n--;

            if (map.containsKey(p)) {
                for (int[] neighbour : map.get(p)) {
                    int e = neighbour[0];
                    int w = neighbour[1];
                    if (dist[e] > w + dist[p]) {
                        vis[e] = true;
                        dist[e] = w + dist[p];
                        q.add(new int[]{dist[e], e});
                    }
                }
            }
        }

        System.out.println(n);

        for (i = 1; i < dist.length; i++) {
            System.out.println(dist[i]);
            ans = Math.max(ans, dist[i]);
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
