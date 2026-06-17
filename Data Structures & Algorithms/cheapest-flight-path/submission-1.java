class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int i = 0, j = 0;
        int[][] dist = new int[n + 1][k + 1];
        Map<Integer, List<int[]>> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for (i = 0; i < dist.length; i++) {
            for (j = 0; j < dist[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;

        for (int[] flight : flights) {
            int a = flight[0];
            int b = flight[1];
            int cost = flight[2];

            map.computeIfAbsent(a, m -> new ArrayList<>()).add(new int[]{b, cost});
        }

        pq.add(new int[]{0, 0, src});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int price = top[0];
            int stop = top[1];
            int ele = top[2];

            //System.out.println(ele + " " + price + " " + stop);

            if (ele == dst) {
                return price;
            }

            if (stop >= k + 1) continue;

            if (map.containsKey(ele)) {
                for (int[] side : map.get(ele)) {
                    System.out.println(side[0]);
                    if (price + side[1] < dist[side[0]][stop]) {
                        dist[side[0]][stop] = price + side[1];
                        pq.add(new int[]{dist[side[0]][stop], stop + 1, side[0]});
                    }
                }
            }
        }

        return -1;
    }
}
