class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        solve(0, s, list, ans);

        return ans;
    }

    private void solve(int idx, String s, List<String> list, List<List<String>> ans) {
        if (idx >= s.length() && !ans.contains(list)) {
            System.out.println("Here" + " " + list.toString());
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String palindrome = s.substring(idx, i + 1);
            // System.out.println("Partitions " + palindrome);
            if (isPalindrome(palindrome)) {
                // System.out.println(palindrome);
                list.add(palindrome);
                solve(i + 1, s, list, ans);
                list.remove(list.size() - 1);
            }
        }

        return;
    }

    private boolean isPalindrome(String palindrome) {
        int l = 0, r = palindrome.length() - 1;

        while (l <= r) {
            if (palindrome.charAt(l) != palindrome.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
