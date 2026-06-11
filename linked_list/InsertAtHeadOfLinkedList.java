/*
Problem: Insert At Head Of Linked List

Description:
Given the head of a singly linked list and a value X,
insert a new node with value X at the beginning of the list
and return the new head.

Approach: Direct Head Insertion

Time Complexity: O(1)
Space Complexity: O(1)

Key Idea:
- Create a new node
- Point it to current head
- Return it as the new head
*/

class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}

class InsertAtHeadOfLinkedList {

    public ListNode insertAtHead(ListNode head, int X) {

        ListNode temp = new ListNode(X);

        temp.next = head;

        return temp;
    }
}