class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head); // dummy đứng trước head
        ListNode slow = dummy;
        ListNode fast = dummy;

        // fast đi trước n bước
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // cả 2 cùng đi tới khi fast ở node cuối cùng
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow đang đứng ngay trước node cần xóa
        slow.next = slow.next.next;

        return dummy.next; // không return head, vì head có thể đã bị xóa
    }
}
