class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for (int ele : stones) {
            pq.add(ele);
        }

        while (pq.size() >= 2) {
            if (pq.size() >= 2) {
                int x = pq.poll();
                int y = pq.poll();
                // System.out.println(y + " " + x);

                if (x == y) {
                    continue;
                } else if (y > x || x > y) {
                    // System.out.println(Math.abs(y -  x));
                    pq.add(Math.abs(y - x));
                } else {
                    continue;
                }
            }
        }

        return (!pq.isEmpty()) ? pq.peek() : 0;
    }
}
