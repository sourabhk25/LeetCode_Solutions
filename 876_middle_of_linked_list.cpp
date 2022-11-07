struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        if(head==nullptr || head->next==nullptr){
            return head;
        } else{
            ListNode* slow = head;
            ListNode* fast = head;
            while(fast->next!=nullptr){
                if(fast->next!=nullptr){
                    fast = fast->next->next;
                }
                slow = slow->next;
                if(fast==nullptr){
                    break;
                }
            }
            return slow;
        }
    }
};