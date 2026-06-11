/*
    Problem: Flatten Linked List

    Description:
    Given a linked list where each node has:
    - next pointer (horizontal list)
    - child pointer (vertical sorted list)

    Flatten it into a single sorted linked list using child pointers only.

    Approach: Recursion + Merge (like Merge Sort)

    Time Complexity: O(N), where N is total nodes
    Space Complexity: O(N) recursion stack

    Key Idea:
    1. Flatten the list on the right (next pointers)
    2. Merge current list (child chain) with flattened right list
    3. Always use child pointers for final structure
*/

class FlattenLinkedList {

    // main flatten function
    public ListNode flattenLinkedList(ListNode head) {

        // base case
        if (head == null || head.next == null)
            return head;

        // Step 1: flatten remaining list on right
        ListNode mergedNext = flattenLinkedList(head.next);

        // Step 2: detach next pointer (we only use child now)
        head.next = null;

        // Step 3: merge current list with flattened list
        return merge(head, mergedNext);
    }

    // merge two sorted child-linked lists
    private ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (a != null && b != null) {

            if (a.val < b.val) {
                temp.child = a;
                a = a.child;
            } else {
                temp.child = b;
                b = b.child;
            }

            temp = temp.child;
        }

        // attach remaining nodes
        if (a != null) temp.child = a;
        else temp.child = b;

        return dummy.child;
    }

    // ------------------ MAIN FUNCTION ------------------
    public static void main(String[] args) {

        /*
            Example:
            5 -> 10 -> 19 -> 28
            |    |     |     |
            7    20    22    35
            |          |
            8          50
            |
            30

            After flattening:
            5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 30 -> 35 -> 50
        */

        FlattenLinkedList sol = new FlattenLinkedList();

        // Sample construction (simplified)
        ListNode head = new ListNode(5);
        head.next = new ListNode(10);
        head.next.next = new ListNode(19);

        // flatten call
        ListNode result = sol.flattenLinkedList(head);

        // print result
        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.child;
        }
    }
}