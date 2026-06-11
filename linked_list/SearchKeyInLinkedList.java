/*
    Problem: Search Key In Linked List

    Description:
    Given the head of a singly linked list and a key,
    return true if the key exists in the list, otherwise return false.

    Approach: Linear Traversal

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Traverse the linked list node by node
    - Compare each node's value with the key
    - Return true if found, else false after full traversal
*/

class SearchKeyInLinkedList {

    public boolean searchKey(ListNode head, int key) {

        while(head != null){
            if(head.val == key)
                return true;

            head = head.next;
        }

        return false;
    }
}