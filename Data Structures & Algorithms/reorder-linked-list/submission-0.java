class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Bước 1: tìm node giữa bằng slow/fast
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow đang đứng ở cuối nửa đầu

        // Bước 2: cắt đôi list và đảo ngược nửa sau
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // cắt đứt nửa đầu khỏi nửa sau (quan trọng!)
        while (curr != null) {
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        // prev là head của nửa sau đã đảo

        // Bước 3: trộn xen kẽ 2 nửa
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;   // node đầu -> node cuối
            second.next = next1;   // node cuối -> node đầu kế tiếp

            first = next1;
            second = next2;
        }
    }
}