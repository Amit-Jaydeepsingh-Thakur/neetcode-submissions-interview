class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if (!wordList.contains(endWord)) {
            return 0;
        }
        
        int i = 0, j = 0, level = 1;
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        vis.add(beginWord);
        q.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();

            for (i = 1; i <= size; i++) {
                String top = q.poll();

                if (top.equals(endWord)) {
                    return level;
                }

                char[] arr = top.toCharArray();

                for (j = 0; j < arr.length; j++) {
                    char org = arr[j];
                    
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;

                        String s = new String(arr);

                        if (wordList.contains(s) && !vis.contains(s)) {
                            q.add(s);
                            vis.add(s);
                        }
                    }

                    arr[j] = org;
                }
            }

            level++;
        }

        return 0;
    }
}
