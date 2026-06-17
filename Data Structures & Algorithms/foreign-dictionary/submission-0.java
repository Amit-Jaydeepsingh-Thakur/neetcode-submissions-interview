class Solution {
    public String foreignDictionary(String[] words) {
        int i = 0, j = 0;
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String s : words) {
            for (char ch : s.toCharArray()) {
                map.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }
        for (i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }

            for (j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!map.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        map.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    }

                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            char ch = q.poll();
            sb.append(ch);

            for (char n : map.get(ch)) {
                indegree.put(n, indegree.get(n) - 1);
                if (indegree.get(n) == 0) {
                    q.add(n);
                }
            }    
        }

        if (sb.length() != indegree.size()) {
            return "";
        }

        return sb.toString();
    }
}
