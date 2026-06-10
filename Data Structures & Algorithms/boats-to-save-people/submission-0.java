class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0, cnt = 0, sum = 0, r = people.length - 1;
        Arrays.sort(people);

        while (l <= r) {
            int remain = limit - people[r--];
            cnt++;

            if (l <= r && remain >= people[l]) {
                l++;
            } 
        }

        return cnt;
    }
}