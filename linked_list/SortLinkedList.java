/*
    Problem: Sort Linked List

    Description:
    Given the head of a linked list, sort it in ascending order.

    Approach: Merge Sort (Divide and Conquer)

    Time Complexity: O(n log n)
    Space Complexity: O(log n) (recursion stack)

    Key Idea:
    1. Split linked list into two halves using slow-fast pointer
    2. Recursively sort both halves
    3. Merge two sorted linked lists

    Why it works:
    - Merge sort is ideal for linked lists (no random access needed)
    - Splitting + merging preserves O(n log n) efficiency
*/

class SortLinkedList {

    // find middle node
    public ListNode findMid(ListNode head){
        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // merge two sorted lists
    public ListNode mergeList(ListNode leftHead, ListNode rightHead){

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(leftHead != null && rightHead != null){

            if(leftHead.val <= rightHead.val){
                tail.next = leftHead;
                leftHead = leftHead.next;
            } else {
                tail.next = rightHead;
                rightHead = rightHead.next;
            }

            tail = tail.next;
        }

        if(leftHead != null) tail.next = leftHead;
        if(rightHead != null) tail.next = rightHead;

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;

        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        return mergeList(leftSorted, rightSorted);
    }
}