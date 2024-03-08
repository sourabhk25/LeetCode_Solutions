class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> temp;
        temp.push_back(nums[0]);
        for(int i = 1; i < n; i++) {
            if(nums[i] > temp.back()) {
                temp.push_back(nums[i]);
            } else {
                auto ind = lower_bound(temp.begin(), temp.end(), nums[i]);
                int ind_convt = ind - temp.begin();
                temp[ind_convt] = nums[i];
            }        
        }
        return temp.size();
    }
};