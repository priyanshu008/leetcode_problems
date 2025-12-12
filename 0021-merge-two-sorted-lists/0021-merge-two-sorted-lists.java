/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode nn = new ListNode(-1);
        ListNode cn = nn;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                cn.next = list1;
                list1 = list1.next;
            }else{
                cn.next = list2;
                list2 = list2.next;
            }
            cn = cn.next;
        }
        if (list1 != null){
            cn.next = list1;
        }
        if (list2 != null){
            cn.next = list2;
        }

        return nn.next;
    }
}