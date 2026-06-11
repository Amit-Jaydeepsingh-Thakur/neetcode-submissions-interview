class StockSpanner {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public StockSpanner() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public int next(int price) {
        int days = 0;

        if (st1.isEmpty()) {
            st1.push(price);
        } else {
            while (!st1.isEmpty() && st1.peek() <= price) {
                days++;
                st2.push(st1.pop());
            }

            while(!st2.isEmpty()) {
                st1.push(st2.pop());
            }

            st1.push(price);
        }

        return days + 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */