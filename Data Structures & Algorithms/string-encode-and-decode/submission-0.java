class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb  = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        System.out.println(str);

        while (i < str.length()) {
            int j = i + 1;

            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));

            i = j + 1;

            System.out.println(str.substring(i, j + 1));

            ans.add(str.substring(i, i + len));

            i += len;
        }
        
        return ans;
    }
}
