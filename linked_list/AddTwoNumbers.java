/*
    Problem: Add Two Numbers (Linked List)

    Description:
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each node contains a single digit.
    Add the two numbers and return the sum as a linked list.

    Approach: Digit-wise Addition with Carry

    Time Complexity: O(max(n, m))
    Space Complexity: O(max(n, m))

    Key Idea:
    - Traverse both linked lists simultaneously
    - Add corresponding digits + carry
    - Store result digit in new node
    - Update carry for next iteration

    Why it works:
    - Reverse order means least significant digit comes first
    - Simulates normal addition from right to left
*/

class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode currA = l1;
        ListNode currB = l2;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;

        while(currA != null || currB != null){

            int a = (currA == null) ? 0 : currA.val;
            int b = (currB == null) ? 0 : currB.val;

            if(currA != null) currA = currA.next;
            if(currB != null) currB = currB.next;

            int sum = a + b + carry;

            carry = sum / 10;
            sum = sum % 10;

            tail.next = new ListNode(sum);
            tail = tail.next;
        }

        // handle leftover carry
        if(carry > 0){
            tail.next = new ListNode(carry);
        }

        return dummy.next;
    }
}