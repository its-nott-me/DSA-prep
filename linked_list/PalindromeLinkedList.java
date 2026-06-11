/*
    Problem: Palindrome Linked List

    Description:
    Given the head of a singly linked list, determine if it is a palindrome.

    Approach: Slow/Fast Pointer + Reverse Second Half

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    1. Find middle of the linked list using slow and fast pointers
    2. Reverse the second half of the list
    3. Compare first half and reversed second half

    Why it works:
    - Palindrome means symmetry around center
    - Reversing second half allows direct comparison
*/

class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head, fast = head;

        // Step 1: find middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: reverse second half
        ListNode nextNode = null, prevNode = null;

        while(slow != null){
            nextNode = slow.next;
            slow.next = prevNode;

            prevNode = slow;
            slow = nextNode;
        }

        // Step 3: compare halves
        ListNode first = head;
        ListNode second = prevNode;

        while(second != null){
            if(first.val != second.val){
                return false;
            }

            first = first.next;
            second = second.next;
        }

        return true;
    }
}