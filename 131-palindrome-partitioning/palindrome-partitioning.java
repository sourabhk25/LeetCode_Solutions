class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path) {
        if(pivot == s.length()) {
            //we would be having valid pandromic partition
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = pivot; i < s.length(); i++) {
            String subStr = s.substring(pivot, i+1);
            if(isPalindrome(subStr)) {
                //action
                path.add(subStr);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}