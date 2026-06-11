/*
    Problem: Reverse Nodes in K-Group

    Description:
    Given the head of a linked list, reverse the nodes of the list k at a time,
    and return its modified list. If the number of nodes is not a multiple of k,
    leave the remaining nodes as-is.

    Approach: Dummy Node + Group-wise Reversal

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Process list in chunks of size k
    - Before reversing, ensure k nodes exist
    - Reverse each group independently
    - Connect previous group with reversed group

    Why it works:
    - Local reversal of fixed-size segments preserves correctness
    - Dummy node simplifies head updates
*/

class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;
        ListNode curr = head;

        while(true){

            // Step 1: check if k nodes exist
            ListNode check = curr;

            for(int i = 0; i < k; i++){
                if(check == null)
                    return dummy.next;
                check = check.next;
            }

            // Step 2: reverse k nodes
            ListNode groupHead = curr;
            ListNode prev = null;

            for(int i = 0; i < k; i++){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Step 3: reconnect groups
            prevGroupTail.next = prev;
            groupHead.next = curr;

            // move tail forward
            prevGroupTail = groupHead;
        }
    }
}