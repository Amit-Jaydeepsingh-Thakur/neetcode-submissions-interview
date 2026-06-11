class Solution {
    public int calPoints(String[] operations) {
        int i = 0, j = 0, sum = 0;
        Stack<Integer> st = new Stack<>();

        for (String s : operations) {

            if (s.equals("+")) {
                //if (st.size() >= 2) {
                    int num1 = st.pop();
                    int num2 = st.peek();

                    int res = num1 + num2;
                    st.push(num1);
                    //st.push(num2);
                    st.push(res);
                //}
            } else if (s.equals("C")) {
                int top = st.pop();
            } else if (s.equals("D")) {
                int top = st.peek();
                st.push(top * 2);

            } else {
                st.push(Integer.parseInt(s));
            }
        }

        while (!st.isEmpty()) {
            sum += st.pop();
        }
        

        return sum;
    }
}