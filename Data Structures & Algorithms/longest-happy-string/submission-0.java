class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int i = 0, j = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((k, l) -> (l[0] - k[0]));
        StringBuilder sb = new StringBuilder();

        if (a > 0) {
            pq.add(new int[]{a, 'a'});
        }

        if (b > 0) {
            pq.add(new int[]{b, 'b'});
        }

        if (c > 0) {
            pq.add(new int[]{c, 'c'});
        }

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            if (sb.length() > 1 && sb.charAt(sb.length() -1) == top[1]
                && sb.charAt(sb.length() - 2) == top[1]) {
                    if (pq.isEmpty()) break;
                    int[] sec = pq.poll();
                    sb.append((char) sec[1]);
                    sec[0]--;
                    if (sec[0] > 0) {
                        pq.add(sec);
                    }
                    pq.add(top);
            } else {
                sb.append((char) top[1]);
                top[0]--;
                if (top[0] > 0) {
                    pq.add(top);
                }
            }

        }

        return sb.toString();
    }
}