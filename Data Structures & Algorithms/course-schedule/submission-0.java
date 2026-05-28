class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int i = 0, j = 0;
        int[] indegree = new int[numCourses];
        int[] vis = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        Queue<Integer> q = new LinkedList<>();

        for (int[] arr : prerequisites) {
            int x = arr[0];
            int y = arr[1];

            List<Integer> list = map.get(x);
            list.add(y);
            map.put(x, list);

            indegree[y]++;
        }

        for (i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                vis[i] = 1;
                q.add(i);
            }
        }

        int finish = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            finish++;
            //vis[node] = 1;
            //if (map.containsKey(node)) {
                List<Integer> list = map.get(node);

                for (Integer ele : list) {
                    indegree[ele]--;

                    if (indegree[ele] == 0) {
                        vis[ele] = 1;
                        q.add(ele);
                    }
                }
            // }
        }

        return finish == numCourses;
    }
}
