/*
    Problem: Delete All Occurrences In Doubly Linked List

    Description:
    Given the head of a doubly linked list and a target value,
    delete all nodes that contain the target value.

    Approach: Dummy Node + Linear Traversal

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Use a dummy node before head to simplify edge cases
    - Traverse the list normally
    - Remove matching nodes by rewiring prev/next pointers
    - Return dummy.next as new head
*/

class DeleteAllOccurrencesInDoublyLinkedList {

    public ListNode deleteAllOccurrences(ListNode head, int target) {

        // dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        if (head != null) {
            head.prev = dummy;
        }

        ListNode curr = head;

        while (curr != null) {

            if (curr.val == target) {

                ListNode nextNode = curr.next;
                ListNode prevNode = curr.prev;

                // bypass current node
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
            }

            curr = curr.next;
        }

        // return real head
        ListNode newHead = dummy.next;
        if (newHead != null) {
            newHead.prev = null;
        }

        return newHead;
    }
}