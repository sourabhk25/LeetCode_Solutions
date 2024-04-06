class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!stack.isEmpty() && Math.abs(stack.getLast() - ch) == 32) {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }

        String ans = "";
        for(char ch: stack) {
            ans += ch;
        }

        return ans;
    }
}