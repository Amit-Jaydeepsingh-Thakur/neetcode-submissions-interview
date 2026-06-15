class Solution {
    public int openLock(String[] deadends, String target) {
        int i = 0, j = 0, time = 0;

        String start = "0000";

        Set<String> set = new HashSet<>();
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
    

        for (String s : deadends) {
            set.add(s);
        }

        if (set.contains(start) || set.contains(target)) {
            return -1;
        }

        vis.add(start);
        q.add(start);

        while (!q.isEmpty()) {
            int size = q.size();

            for (i = 1; i <= size; i++) {
                String top = q.poll();

                if (top.equals(target)) {
                    return time;
                }

                for (String next : getNext(top)) {
                    if (!set.contains(next) && !vis.contains(next)) {
                        q.add(next);
                        vis.add(next);
                    }
                }
            }

            time++;
        }

        return -1;
    }

    private List<String> getNext(String s) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            char[] arr = s.toCharArray();

            char ch = arr[i];
            arr[i] = ch == '9' ? '0' : (char) (ch + 1);
            ans.add(new String(arr));

            arr[i] = ch == '0' ? '9' : (char) (ch - 1);
            ans.add(new String(arr));
        }

        return ans;
    }
}