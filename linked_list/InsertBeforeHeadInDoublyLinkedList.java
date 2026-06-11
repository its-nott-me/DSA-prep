/*
    Problem: Insert Before Head In Doubly Linked List

    Description:
    Given the head of a doubly linked list and a value data,
    insert a new node before the head and return the new head.

    Approach: Direct Head Insertion (Doubly Linked List)

    Time Complexity: O(1)
    Space Complexity: O(1)

    Key Idea:
    - Create a new node
    - Point its next to current head
    - Update previous pointer of old head
    - Return new node as new head
*/
class ListNode {
    public int data;
    public ListNode prev;
    public ListNode next;
    public ListNode();
    public ListNode(int data);
    public ListNode(int data, ListNode prev, ListNode next);
};

class InsertBeforeHeadInDoublyLinkedList {

    public ListNode insertBeforeHead(ListNode head, int data) {

        ListNode newNode = new ListNode(data);

        if(head == null){
            return newNode;
        }

        newNode.next = head;
        head.prev = newNode;

        return newNode;
    }
}