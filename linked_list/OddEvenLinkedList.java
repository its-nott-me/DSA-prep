/*
    Problem: Odd Even Linked List

    Description:
    Given the head of a singly linked list, group all nodes at odd indices
    together followed by nodes at even indices. Maintain relative order.

    Approach: Two Pointer (Odd-Even Separation)

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Maintain two chains:
        odd list (1st, 3rd, 5th...)
        even list (2nd, 4th, 6th...)
    - Reconnect them at the end

    Why it works:
    - We rearrange pointers without creating new nodes
    - Preserves original relative order within odd and even groups
*/

class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        ListNode oddHead = head, evenHead = head.next;
        ListNode oddNode = oddHead, evenNode = evenHead;

        // split odd and even nodes
        while(oddNode != null && oddNode.next != null &&
              evenNode != null && evenNode.next != null){

            oddNode.next = oddNode.next.next;
            evenNode.next = evenNode.next.next;

            oddNode = oddNode.next;
            evenNode = evenNode.next;
        }

        // connect odd list with even list
        oddNode.next = evenHead;

        return oddHead;
    }
}