/*
    Problem: Linked List Cycle Detection

    Description:
    Given the head of a singly linked list, determine if the list
    contains a cycle. A cycle exists if a node can be revisited by
    continuously following next pointers.

    Approach: Floyd’s Cycle Detection (Slow & Fast Pointer)

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Use two pointers:
        slow moves 1 step
        fast moves 2 steps
    - If there is a cycle, they will eventually meet
    - If fast reaches null, no cycle exists

    Why it works:
    - In a cycle, fast "laps" slow pointer
*/

class LinkedListCycleDetection {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}