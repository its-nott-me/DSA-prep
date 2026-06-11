/*
    Problem: Delete The Middle Node Of A Linked List

    Description:
    Given the head of a singly linked list, delete the middle node
    and return the modified list.

    If there are two middle nodes, delete the second middle node.

    Approach: Slow & Fast Pointer (Two Pointers)

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Use slow and fast pointers
    - fast moves 2 steps, slow moves 1 step
    - slow reaches just before middle using dummy node
    - delete slow.next (middle node)

    Why it works:
    - Fast pointer reaches end twice as fast
    - Slow pointer lands at midpoint
*/

class DeleteTheMiddleNodeOfALinkedList {

    public ListNode deleteMiddle(ListNode head) {

        if(head == null || head.next == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = dummy;

        // find middle
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // delete middle node
        slow.next = slow.next.next;

        return dummy.next;
    }
}