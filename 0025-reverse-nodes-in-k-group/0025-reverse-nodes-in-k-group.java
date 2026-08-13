class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (true) {
            ListNode node = prev;
            for (int i = 0; i < k && node != null; i++) node = node.next;
            if (node == null) break;
            ListNode curr = prev.next;
            ListNode next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
        }
        return dummy.next;
    }
}
