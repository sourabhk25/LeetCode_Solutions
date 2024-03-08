class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> ans;
        int rows = matrix.size(), columns = matrix[0].size();
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        while(left <= right && top <= bottom) {
            // right direction
            for(int i = left; i <= right; i++) {
                ans.push_back(matrix[top][i]);
            }
            top++;

            //down direction
            for(int j = top; j <= bottom; j++) {
                ans.push_back(matrix[j][right]);
            }
            right--;

            if(top <= bottom) { //to handle single row case
                //left direction
                for(int i = right; i >= left; i--) {
                    ans.push_back(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if(left <= right) { //to handle single column case
                //up direction
                for(int j = bottom; j >= top; j--) {
                    ans.push_back(matrix[j][left]);
                }
                left++;
            }
            
        }

        return ans;
    }
};