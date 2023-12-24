class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char sign = '+';    //default sign is +
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                int val = 0;
                while(i < n && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');   //handling case of no. of with multiple digits
                    i++;
                }
                i--;
                if(sign == '+') {
                    st.push(val);
                } else if(sign == '-') {
                    st.push(-val);
                } else if(sign == '*') {
                    int a = st.pop();
                    int ans = a * val;
                    st.push(ans); 
                } else if(sign == '/') {
                    int a = st.pop();
                    int ans = a / val;
                    st.push(ans); 
                }
            } else if(ch != ' ') {  //if not whitespace
                sign = ch;  //assign sign
            }
        }

        int sum = 0;
        while(!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}