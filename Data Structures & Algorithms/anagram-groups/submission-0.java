class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int i = 0, j = 0;
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String s : strs) {
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            String str = new String(sorted);

            if (!map.containsKey(str)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(str, list);
            } else {
                List<String> list = map.get(str);
                list.add(s);
                map.put(str, list);
            }
        }

        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            String key = e.getKey();
            List<String> list = e.getValue();
            ans.add(list);
        }

        return ans;
    }
}
