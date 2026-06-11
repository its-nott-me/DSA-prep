/*
    Problem: Delete Node In A Linked List

    Description:
    You are given a node in a singly linked list (not the head).
    Delete this node from the list. You are not given access to the head.

    Approach: Value Overwrite (In-place Deletion)

    Time Complexity: O(1)
    Space Complexity: O(1)

    Key Idea:
    - You cannot access previous node
    - So copy the next node's value into current node
    - Then bypass the next node

    Why it works:
    - Effectively "shifts" all values left by one step
    - Deletes next node instead of current node

    Notes:
    - Assumes node is not the last node (guaranteed by problem)
*/


class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}