class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st = new Stack<>();
        for(String tk:tokens){
            if(tk.equals("+")){
            int b = st.pop();
            int a = st.pop();
            st.push(a+b);
            } else if(tk.equals("-")){
                int b = st.pop();
                int a = st.pop();
                st.push(a-b);
            } else if(tk.equals("*")){
                int b = st.pop();
                int a = st.pop();
                 st.push(a*b);
            } else if(tk.equals("/")){
                 int b = st.pop();
                 int a = st.pop();
                 st.push(a/b);
            } else {
                st.push(Integer.parseInt(tk));
            }
        }
        return st.pop();
    }
}
