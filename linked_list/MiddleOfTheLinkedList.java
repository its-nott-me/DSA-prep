/*
    Problem: Middle of the Linked List

    Description:
    Given the head of a singly linked list, return the middle node.
    If there are two middle nodes, return the second middle node.

    Approach: Slow and Fast Pointer

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Use two pointers:
        slow moves 1 step at a time
        fast moves 2 steps at a time
    - When fast reaches end, slow is at middle

    Why it works:
    - Fast pointer covers twice the distance of slow pointer
    - So when fast finishes, slow is halfway

    Notes:
    - Automatically handles even/odd length lists
*/

class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}