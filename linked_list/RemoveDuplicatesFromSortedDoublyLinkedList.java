/*
    Problem: Remove Duplicates From Sorted Doubly Linked List

    Description:
    Given the head of a sorted doubly linked list, remove all duplicate
    nodes so that each element appears only once.

    Approach: Single Pass Traversal

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Since list is sorted, duplicates are adjacent
    - Compare current node with next node
    - If equal, delete next node by rewiring pointers
    - Otherwise move forward

    Why it works:
    - Sorted property ensures all duplicates are consecutive
*/

class RemoveDuplicatesFromSortedDoublyLinkedList {

    public ListNode removeDuplicates(ListNode head) {

        if(head == null) return null;

        ListNode curr = head;

        while(curr != null && curr.next != null){

            if(curr.val == curr.next.val){

                ListNode dup = curr.next;

                curr.next = dup.next;

                if(dup.next != null){
                    dup.next.prev = curr;
                }

            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}