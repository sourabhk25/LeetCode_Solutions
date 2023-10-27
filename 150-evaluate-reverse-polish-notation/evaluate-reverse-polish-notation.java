class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token: tokens) {
            if(!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                if(token.contains("+")) {
                    stack.push(num1 + num2);
                } else if(token.contains("-")) {
                    stack.push(num1 - num2);
                } else if(token.contains("*")) {
                    stack.push(num1 * num2);
                } else {
                    stack.push(num1 / num2);
                }
                
            }
        }

        return stack.peek();
    }
}