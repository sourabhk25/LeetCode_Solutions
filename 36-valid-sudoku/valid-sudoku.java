class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] columns = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];
        int boxCnt = 0;

        for(int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                char temp = board[i][j];
                if(temp == '.') {
                    continue;   //skip cell
                }
                if(rows[i].contains(temp)) {
                    return false;
                }
                rows[i].add(temp);
                if(columns[j].contains(temp)) {
                    return false;
                }
                columns[j].add(temp);
            }
        }

//loop again for boxes and move i j only by 3, so inside 3x3 can be done using k and l
        for(int i = 0; i < n; i += 3) {
            for(int j = 0; j < n; j += 3) {
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        char temp = board[i + k][j + l];
                        if(temp == '.') {
                            continue;   //skip cell
                        }

                        if(boxes[boxCnt].contains(temp)) {
                            return false;
                        }
                        boxes[boxCnt].add(temp);
                    }
                }
                boxCnt++;
            }
        }

        return true;
    }
}