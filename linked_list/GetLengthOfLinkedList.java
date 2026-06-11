/*
    Problem: Get Length Of Linked List

    Description:
    Given the head of a singly linked list, return the number of nodes
    present in the list.

    Approach: Iterative Traversal

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Traverse the linked list from head to end
    - Count each node until reaching null
*/

class GetLengthOfLinkedList {

    public int getLength(ListNode head) {
        int count = 0;

        while(head != null){
            count++;
            head = head.next;
        }

        return count;
    }
}