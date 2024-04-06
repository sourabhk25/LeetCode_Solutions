class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indices = new HashSet<>();
        String ans = "";
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(i);
            } else if(ch == ')') {
                if(stack.isEmpty()) {
                    indices.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        //put any remaining indices to Set
        while(!stack.isEmpty()) {
            indices.add(stack.pop());
        }

        for(int i = 0; i < s.length(); i++) {
            if(!indices.contains(i)) {
                ans += s.charAt(i);
            }
        }

        return ans;
    }
}