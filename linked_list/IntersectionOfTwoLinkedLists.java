/*
    Problem: Intersection Of Two Linked Lists

    Description:
    Given two singly linked lists headA and headB, return the node
    at which the two lists intersect. If no intersection exists,
    return null.

    Approach: Two Pointer Switching Technique

    Time Complexity: O(n + m)
    Space Complexity: O(1)

    Key Idea:
    - Use two pointers tempA and tempB
    - When a pointer reaches end, redirect it to the other list's head
    - Both pointers traverse equal total distance
    - They meet at intersection node or null

    Why it works:
    - Aligns both pointers by compensating length difference
*/

class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA != tempB){

            // switch to other list when reaching end
            tempA = (tempA == null) ? headB : tempA.next;
            tempB = (tempB == null) ? headA : tempB.next;
        }

        return tempA; // either intersection or null
    }
}