class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for (String s : strs) {
            String sorted = sortString(s);
            if (!map.containsKey(sorted)) {
                List<String> set = new ArrayList<>();
                set.add(s);
                map.put(sorted, set);
            } else {
                List<String> set = map.get(sorted);
                set.add(s);
                map.put(sorted, set);
            }
        }

        // System.out.println(map.size());

        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            String s = e.getKey();
            List<String> val = e.getValue();

            //System.out.println(s + " " + val.toString());

            // List<String> temp = new ArrayList<>();

            // for (String str : val) {
            //     temp.add(str);
            // }

            list.add(val);
        }

        return list;
        
    }

    private String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
