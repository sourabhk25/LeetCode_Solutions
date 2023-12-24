class Solution {
    public int calculate(String s) {
        int sum = 0;
        int sign = 1;
        int n = s.length();
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) { //if ch is digit
                int val = 0;
                while(i < n && Character.isDigit(s.charAt(i))) {    //handle no. owith multiple digits
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;    //decrement i after loop 
                val = val * sign;   //calculate val
                sum += val; //add val to sum
                sign = 1;   //reset sign
            } else if(ch == '(') {
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            } else if(ch == ')') {
                sum *= st.pop();    //update sign
                sum += st.pop();
            } else if(ch == '-') {
                sign *= -1;
            }
        }
        
        return sum;
    }
}