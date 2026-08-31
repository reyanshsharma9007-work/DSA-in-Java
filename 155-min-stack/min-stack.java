import java.util.Stack;

class MinStack {

    Stack<Long> st = new Stack<>();
    long mini;

    public MinStack() {
    }

    public void push(int value) {

        if (st.empty()) {
            st.push((long) value);
            mini = value;
        } 
        else if (value >= mini) {
            st.push((long) value);
        } 
        else {
            // Store modified value
            st.push(2L * value - mini);
            mini = value;
        }
    }

    public void pop() {

        if (st.empty()) return;

        long top = st.pop();

        // If top is modified, restore previous minimum
        if (top < mini) {
            mini = 2 * mini - top;
        }
    }

    public int top() {

        long top = st.peek();

        if (top >= mini) {
            return (int) top;
        }

        // Modified value means actual top is mini
        return (int) mini;
    }

    public int getMin() {
        return (int) mini;
    }
}