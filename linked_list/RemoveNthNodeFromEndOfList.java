/*
    Problem: Remove Nth Node From End Of List

    Description:
    Given the head of a linked list, remove the nth node from the end
    and return the modified list.

    Approach: Two Pointer (Fast-Slow) with Dummy Node

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Use a dummy node to handle edge cases (like deleting head)
    - Move fast pointer n+1 steps ahead
    - Move both fast and slow until fast reaches end
    - slow.next is the node to delete

    Why it works:
    - Maintains fixed gap of n nodes between pointers
    - When fast reaches end, slow is just before target node
*/

class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // move fast pointer n+1 steps ahead
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        // move both until fast reaches end
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        // delete nth node from end
        slow.next = slow.next.next;

        return dummy.next;
    }
}