class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Base cases: empty list, single node, or no rotations needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Count the total nodes and locate the tail node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Handle edge cases where k is a multiple of length
        k = k % length;
        if (k == 0) {
            return head;
        }

        // Step 3: Connect tail to head to form a circular list
        tail.next = head;

        // Step 4: Find the new tail (length - k steps from the head)
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 5: The new head is right after the new tail, then sever the connection
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}