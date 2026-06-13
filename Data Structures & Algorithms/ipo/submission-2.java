class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int i = 0, ans = w;
        PriorityQueue<int[]> cap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> (b - a));

        for (i = 0; i < profits.length; i++) {
            cap.add(new int[]{capital[i], profits[i]});
        }

        for (i = 0 ; i < k; i++) {
            while (!cap.isEmpty() && cap.peek()[0] <= w) {
                maxProfit.add(cap.poll()[1]);
            }

            if (maxProfit.isEmpty()) {
                break;
            }

            w += maxProfit.poll();
        }


        return w;
    }

    private int findBestMatch(int cap, TreeMap<Integer, PriorityQueue<Integer>> map) {
        int max = Integer.MIN_VALUE, prev = max, last = -1;

        if (map.containsKey(cap)) {
            return map.get(cap).poll();
        } else {
            for (Map.Entry<Integer, PriorityQueue<Integer>> e : map.entrySet()) {
                int key = e.getKey();

                if (cap >= key) {
                    max = Math.max(max, (!map.get(key).isEmpty()) ? map.get(key).peek() : max);
                    if (max != prev) {
                        prev = max;
                        last = key;
                    }
                } 
            }

            if (last != -1) { 
                map.get(last).poll(); 
            }
        }

        return max;
    }
}