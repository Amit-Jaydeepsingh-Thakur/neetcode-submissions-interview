class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        int i = 0, j = 0;
        PriorityQueue<String> q = new PriorityQueue<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);

            //indegree.put(dest, indegree.getOrDefault(dest, 0) + 1);
            map.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dest);

        }

        solve("JFK", map, ans);

        Collections.reverse(ans);

        return ans;
    }

    private void solve(String start, Map<String, PriorityQueue<String>> map, List<String> ans) {

        //if (map.containsKey(start)) {
            PriorityQueue<String> pq = map.get(start);
            while (pq != null && !pq.isEmpty()) {
                String top = pq.poll();
                solve(top, map, ans);
            }

            ans.add(start);
        //}
    }
}
