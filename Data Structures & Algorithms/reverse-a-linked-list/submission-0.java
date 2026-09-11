/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;   // sẽ trở thành head mới sau khi đảo xong
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // lưu lại phần còn lại của list trước khi đổi hướng
            curr.next = prev;              // đảo chiều con trỏ
            prev = curr;                   // dịch prev lên
            curr = nextTemp;               // dịch curr lên
        }

        return prev; // khi curr == null, prev đang đứng ở node cuối cùng (head mới)
    }
}
