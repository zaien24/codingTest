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
        ListNode dummy = new ListNode(-1); // 더미 시작 노드
        ListNode current = dummy;           // 실제 연결할 포인터

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;       // 작은 값을 연결
                list1 = list1.next;         // list1 한 칸 전진
            } else {
                current.next = list2;
                list2 = list2.next;         // list2 한 칸 전진
            }
            current = current.next;         // current도 한 칸 전진
        }

        // 둘 중 하나가 남아있다면 연결
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;      // dummy 다음 노드가 진짜 시작점
        
    }
}