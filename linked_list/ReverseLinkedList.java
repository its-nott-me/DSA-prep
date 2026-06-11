/*
    Problem: Reverse Linked List

    Description:
    Given the head of a singly linked list, reverse the list and return
    the new head.

    Approach 1: Iterative (Three Pointers)
    Approach 2: Recursion

    Time Complexity: O(n)
    Space Complexity:
        - Iterative: O(1)
        - Recursive: O(n) (call stack)

    Key Idea (Iterative):
    - Use prev, curr, next pointers
    - Reverse links one by one

    Key Idea (Recursion):
    - Reverse rest of the list
    - Fix current node’s next pointer
*/

class ReverseLinkedList {

    // ---------------- Iterative Approach ----------------
    public ListNode reverseListIterative(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode prevNode = null;
        ListNode curr = head;
        ListNode nextNode;

        while(curr != null){
            nextNode = curr.next;   // store next
            curr.next = prevNode;   // reverse link

            prevNode = curr;        // move prev
            curr = nextNode;        // move curr
        }

        return prevNode;
    }

    // ---------------- Recursive Approach ----------------
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}