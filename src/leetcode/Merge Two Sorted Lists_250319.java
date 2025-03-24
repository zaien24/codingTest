class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 기저 사례 (base case) : 한쪽이 null이면 나머지를 반환
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        
        // 작은 값의 노드를 선택하고, 다음 노드를 재귀적으로 병합
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    }


class ListNode {
    int val;
    ListNode next;

    // 생성자 (값만 입력할 경우)
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // 생성자 (값과 다음 노드를 지정할 경우)
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // next 변수는 다음 노드를 가리키는 포인터 입니다.

}


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 더미(dummy) 노드를 사용하여 병합 리스트의 시작점을 추적
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy; // 현재 노드 포인터 
        
        // list1과 list2를 비교하면서 병합
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next; // 포인터 이동
        }

        // 남은 노드를 병합 리스트에 추가 
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next; // 더미 노드 다음 노드가 병합된 리스트의 시작(head)
    }
}
