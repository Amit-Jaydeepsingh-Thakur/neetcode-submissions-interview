class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int i = 0, j = temperatures.length - 1;
        int[] ans = new int[temperatures.length];
        Stack<int[]> st = new Stack<>();

        for (i = temperatures.length - 1; i >= 0; i--) {
            int ele = temperatures[i];
            if (!st.isEmpty()) {
                while (!st.isEmpty() && st.peek()[0] <= ele) {
                    st.pop();
                }

                ans[j--] = (!st.isEmpty()) ? Math.abs(st.peek()[1] - i) : 0;
                st.push(new int[]{temperatures[i], i});
                
            } else {
                ans[j--] = 0;
                st.push(new int[]{temperatures[i], i});
            }
        }

        return ans;  
    }
}
