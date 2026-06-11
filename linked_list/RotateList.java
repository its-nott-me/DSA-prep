/*
    Problem: Rotate List

    Description:
    Given the head of a linked list, rotate the list to the right by k places.

    Approach: Length Calculation + Circular Linking

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    1. Find length of list and tail node
    2. Make the list circular (tail -> head)
    3. Find new break point using k % n
    4. Break the cycle at correct position

    Why it works:
    - Rotation is equivalent to re-defining head and tail positions
    - Circular conversion simplifies shifting logic
*/

class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0)
            return head;

        // Step 1: find length and tail
        int n = 1;
        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
            n++;
        }

        // Step 2: optimize rotations
        k = k % n;
        if(k == 0) return head;

        // Step 3: make circular
        tail.next = head;

        // Step 4: find new tail (n-k-1 steps from head)
        ListNode newTail = head;
        for(int i = 0; i < n - k - 1; i++){
            newTail = newTail.next;
        }

        // Step 5: define new head and break circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}