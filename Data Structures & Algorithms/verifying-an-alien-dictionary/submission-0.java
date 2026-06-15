class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int i = 0, j = 0;
        int[] freq = new int[26];
        for (i = 0; i < order.length(); i++) {
            freq[order.charAt(i) - 'a'] = i;
        }

        Comparator<String> compare = (w1, w2) -> {
            for (int k = 0 ; k < Math.min(w1.length(), w2.length()); k++) {
                if (w1.charAt(k) != w2.charAt(k)) {
                    return freq[w1.charAt(k) - 'a'] - freq[w2.charAt(k) - 'a'];
                }
            }

            return w1.length() - w2.length();
        };

        String[] cloned = words.clone();

        Arrays.sort(cloned, compare);

        return Arrays.equals(cloned, words);
        
    }
}