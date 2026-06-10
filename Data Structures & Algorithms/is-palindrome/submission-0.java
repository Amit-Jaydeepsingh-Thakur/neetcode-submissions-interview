class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase()
            .trim()
            .replace(" ", "")
            .replaceAll("\\s+", "")
            .replaceAll("[^A-Za-z0-9]", "");

        String rev = new StringBuilder(s).reverse().toString();

        //System.out.println(rev + " " + s);

        if (s.equals(rev)) {
            return true;
        }

        return false;
        
    }
}
