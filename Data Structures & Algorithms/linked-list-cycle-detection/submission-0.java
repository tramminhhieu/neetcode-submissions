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
    public boolean hasCycle(ListNode head) {
    Set<ListNode> visited = new HashSet<>();
    ListNode curr = head;

    while (curr != null) {
        if (visited.contains(curr)) {
            return true; // đã gặp node này trước đó → có cycle
        }
        visited.add(curr);
        curr = curr.next;
    }
    return false; // duyệt hết tới null → không có cycle
}
}
