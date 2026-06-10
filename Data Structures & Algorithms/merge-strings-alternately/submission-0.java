class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0, p2 = 0, flag = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 <= word1.length() - 1 && p2 <= word2.length() - 1) {
            if (flag == 0) {
                sb.append(word1.charAt(p1));
                p1++;
                flag = 1;
            } else {
                sb.append(word2.charAt(p2));
                p2++;
                flag = 0;
            }
        } 

        if (word1.length() > word2.length()) {
            while (p1 <= word1.length() - 1) {
                sb.append(word1.charAt(p1));
                p1++;
            }
        } else if (word1.length() < word2.length()) {
            while (p2 <= word2.length() - 1) {
                sb.append(word2.charAt(p2));
                p2++;
            }
        } else {
            if (p1 <= word1.length() - 1) {
                while (p1 <= word1.length() - 1) {
                    sb.append(word1.charAt(p1));
                    p1++;
                }
            } else {
                while (p2 <= word2.length() - 1) {
                    sb.append(word2.charAt(p2));
                    p2++;
                }
            }
        }

        return sb.toString();
        
    }
}