/*
    Problem: Delete Head In Doubly Linked List

    Description:
    Given the head of a doubly linked list, delete the head node
    and return the new head.

    Approach: Direct Pointer Update

    Time Complexity: O(1)
    Space Complexity: O(1)

    Key Idea:
    - Move head to next node
    - Update prev pointer of new head to null
    - Return updated head
*/
class ListNode {
    public int data;
    public ListNode prev;
    public ListNode next;
    public ListNode();
    public ListNode(int data);
    public ListNode(int data, ListNode prev, ListNode next);
};

class DeleteHeadInDoublyLinkedList {

    public ListNode deleteHead(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }

        ListNode newHead = head.next;
        newHead.prev = null;

        return newHead;
    }
}