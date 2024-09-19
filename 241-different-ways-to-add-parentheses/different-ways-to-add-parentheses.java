class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>[][] memo = new ArrayList[expression.length()][expression.length()];
        return computeResults(expression, memo, 0, expression.length() - 1);
    }

    private List<Integer> computeResults(String expression, List<Integer>[][] memo, int start, int end) {
        if(memo[start][end] != null) {
            return memo[start][end];
        }

        List<Integer> results = new ArrayList<>();

        if(start == end) {
            results.add(expression.charAt(start) - '0');
            return results;
        }

        if(end - start == 1 && Character.isDigit(expression.charAt(start))) {
            int tens = expression.charAt(start) - '0';
            int ones = expression.charAt(end) - '0';
            results.add(10 * tens + ones);
            return results;
        }

        for(int i = start; i <= end; i++) {
            char currentChar = expression.charAt(i);
            if(Character.isDigit(currentChar)) {
                continue;
            }

            List<Integer> leftAnswers = computeResults(expression, memo, start, i - 1);
            List<Integer> rightAnswers = computeResults(expression, memo, i + 1, end);
            for(int leftVal: leftAnswers) {
                for(int rightVal: rightAnswers) {
                    switch (currentChar) {
                        case '+':
                            results.add(leftVal + rightVal);
                            break;
                        case '-':
                            results.add(leftVal - rightVal);
                            break;
                        case '*':
                            results.add(leftVal * rightVal);
                            break;
                    }
                }            
            }
        }

        memo[start][end] = results;

        return results;
    }
}