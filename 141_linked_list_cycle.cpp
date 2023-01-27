#include<map> 
using namespace std;

struct ListNode {
   int val;
   ListNode *next;
   ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    //use map int,bool visited
    bool hasCycle(ListNode *head) {
        map<ListNode*,bool> visited;
        map<ListNode*,bool>::iterator itr;
        ListNode *current = head;
        while(current != nullptr){
            itr = visited.find(current);
            if(itr == visited.end()){
                visited.emplace(current, true);
            } else{
                return true;
            }
            current = current->next;
        }
        return false;        
    }
};