/*
    Problem: Reverse Doubly Linked List

    Description:
    Given the head of a doubly linked list, reverse the list
    and return the new head.

    Approach: Pointer Swapping

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - For each node, swap its prev and next pointers
    - Move to original next (which becomes prev after swap)
    - After traversal, fix new head position
*/

class ReverseDoublyLinkedList {

    public ListNode reverseDLL(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode newHead = null;

        while(curr != null){

            // swap prev and next
            ListNode temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // update new head
            newHead = curr;

            // move to next node (original next is now prev)
            curr = curr.prev;
        }

        return newHead;
    }
}