class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            Set<String> usedWords = new HashSet<>();

            for (int k = 0; k < size; k++) {

                String top = q.poll();

                if (top.equals(endWord)) {
                    return level;
                }

                char[] temp = top.toCharArray();

                for (int i = 0; i < temp.length; i++) {

                    char original = temp[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        temp[i] = ch;

                        String str = new String(temp);

                        if (set.contains(str)) {
                            q.offer(str);
                            usedWords.add(str);
                        }
                    }

                    temp[i] = original;
                }
            }

            for (String word : usedWords) {
                set.remove(word);
            }

            level++;
        }

        return 0;
    }
}