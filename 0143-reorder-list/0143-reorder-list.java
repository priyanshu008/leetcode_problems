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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        int size = getSize(head);
        ListNode[] nums = new ListNode[size];
        ListNode curr = head;

        for(int i = 0; i < size; i++){
            nums[i] = curr;
            curr = curr.next;
        }

        int start = 0;
        int last = size - 1;

        while (start < last){
            nums[start].next = nums[last];
            start++;

            if(start == last){
                break;
            }
            nums[last].next = nums[start];
            last--;
        }

        nums[last].next = null;
    }

    public int getSize(ListNode head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}