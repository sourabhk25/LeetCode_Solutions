class Solution {
    static class Pair {
        Stack<Integer> st;
        char sign;
        Pair(Stack<Integer> st, char sign) {
            this.st = st;
            this.sign = sign;
        }
    }

    private void cal(Stack<Integer> st, int val, char sign) {
        //compare sign value, for +,- push +ve,-ve val. for *,/ calculate ans and push
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
    }
    public int calculate(String s) {
        Stack<Pair> stPar = new Stack<>();  //stack to store details related to parenthesis
        Stack<Integer> st = new Stack<>();  //current stack
        char sign = '+';    //default sign is +
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) { //if ch is a digit
                int val = 0;
                while(i < n && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');   //handling case of no. of with multiple digits
                    i++;
                }
                i--;    //move i back 1 space after loop
                cal(st, val,sign);
            } else if(ch == '(') {
                stPar.push(new Pair(st, sign)); //push current stack and sign as pair to parenthesis stack
                st = new Stack<>(); //reset st variable
                sign = '+'; //reset sign variable with +
            } else if(ch == ')') {  //calculate the val
                int tempval = 0;
                while(!st.isEmpty()) {
                    tempval += st.pop();
                }
                Pair p = stPar.pop();   //get prev stack details
                st = p.st;  //get prev stack      
                sign = p.sign;  //get prev sign
                cal(st, tempval, sign); //calculate total ans for bracket
            } else if(ch != ' ') {  //if not whitespace
                sign = ch;  //assign sign
            }
        }

        int sum = 0;
        while(!st.isEmpty()) {  //calulate sum of all terms on stack
            sum += st.pop();
        }
        return sum;
    }
}