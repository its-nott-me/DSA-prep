/*
    Problem: Linked List Cycle II (Detect Cycle Start)

    Description:
    Given the head of a linked list, return the node where the cycle begins.
    If there is no cycle, return null.

    Approach: Floyd’s Cycle Detection (Slow & Fast Pointer)

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - First detect cycle using slow and fast pointers
    - If they meet, a cycle exists
    - To find the start of the cycle:
        * Set a pointer at head
        * Move both pointers (head pointer and meeting pointer) one step at a time
        * They meet at cycle start

    Why it works:
    - Distance properties inside cycle ensure both pointers align at entry point
*/

class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: detect cycle
        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){

                // Step 2: find cycle start
                ListNode temp = head;

                while(temp != slow){
                    temp = temp.next;
                    slow = slow.next;
                }

                return slow;
            }
        }

        return null;
    }
}