class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int i = 0, j = 0;
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            if (!map.containsKey(b)) {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                map.put(b, list);
            } else {
                List<Integer> list = map.get(b);
                list.add(a);
                map.put(b, list);
            }

            indegree[a]++;
        }

        for (i = 0 ; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                ans[j++] = i;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int top = q.poll();

            if (map.containsKey(top)) {
                for (Integer ele : map.get(top)) {
                    indegree[ele]--;

                    if (indegree[ele] == 0) {
                        ans[j++] = ele;
                        q.add(ele);
                    }
                }
            }
        }

        return (j >= numCourses) ? ans : new int[0];
    }
}
