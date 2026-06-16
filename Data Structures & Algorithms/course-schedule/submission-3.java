class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int i = 0, j = 0;
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            indegree[a]++;
            
            if (!map.containsKey(b)) {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                map.put(b, list);
            } else {
                List<Integer> list = map.get(b);
                list.add(a);
                map.put(b, list);
            }
        }

        for (i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int top = q.poll();

            if (map.containsKey(top)) {
                for (Integer ele : map.get(top)) {
                    indegree[ele]--;

                    if (indegree[ele] == 0) {
                        q.add(ele);
                    }
                }
            }
        }

        for (i = 0; i < indegree.length; i++) {
            // System.
            if (indegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
