class Solution {
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        for(char c: s.toCharArray()) {
            if(c != ' ') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) {
                    while(!stack.isEmpty()) {
                        list.add(stack.pop());
                    }
                    list.add(' ');
                }
            }
        }

        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }

        char[] result;
        int addindex = 0;
        if(list.getLast() != ' ') {
            result = new char[list.size()];
            for(int i=list.size()-1; i>=0; i--) {
                result[addindex] = list.get(i);
                addindex++;
            }    
        } else {
            result = new char[list.size() - 1];
            for(int i=list.size()-2; i>=0; i--) {
                result[addindex] = list.get(i);
                addindex++;
            }
        }
        

        System.out.print("result =");
        System.out.println(result);
        return new String(result);
    }
}