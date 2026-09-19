/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Sort theo start time tăng dần bằng Comparator truyền thống
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });

        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = intervals.get(i - 1);
            Interval curr = intervals.get(i);

            // Chìa khóa: "<" chứ không phải "<=" vì (0,8),(8,10) không conflict
            if (curr.start < prev.end) {
                return false;
            }
        }
        return true;
    }
}
