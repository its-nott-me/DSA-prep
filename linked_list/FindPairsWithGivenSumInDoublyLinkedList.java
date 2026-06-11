/*
    Problem: Find Pairs With Given Sum (Doubly Linked List)

    Description:
    Given the head of a sorted doubly linked list and a target sum,
    return all pairs of nodes whose values add up to the target.

    Approach: Two Pointer (Left + Right)

    Time Complexity: O(n)
    Space Complexity: O(1) (excluding result)

    Key Idea:
    - Use two pointers:
        left  → head
        right → last node
    - Move inward based on sum comparison
    - Since DLL is sorted, we can efficiently shrink range

    Why it works:
    - Small values are at head, large at tail
    - Adjust pointers like classic two-sum in sorted array
*/

import java.util.*;

class FindPairsWithGivenSumInDoublyLinkedList {

    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if(head == null) return result;

        // Step 1: find tail
        ListNode left = head;
        ListNode right = head;

        while(right.next != null){
            right = right.next;
        }

        // Step 2: two pointers
        while(left != null && right != null && left != right && left.prev != right){

            int sum = left.val + right.val;

            if(sum == target){
                result.add(Arrays.asList(left.val, right.val));
                left = left.next;
                right = right.prev;
            }
            else if(sum < target){
                left = left.next;
            }
            else{
                right = right.prev;
            }
        }

        return result;
    }
}