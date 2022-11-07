#include<bits/stdc++.h>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        map<ListNode*, bool> visited;
        ListNode* curr = head;
        // int index = -1;
        while(curr!=nullptr){
            map<ListNode*, bool>::iterator it;
            it = visited.find(curr);
            if(it==visited.end()){
                visited.insert(pair<ListNode*, bool>(curr, true));
            } else{
                return curr;
            }
            curr = curr->next;
            // index++;
        }
        return nullptr;
    }
};