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
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;

        // Sort theo start time
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });

        // Min-heap lưu end time của các meeting đang chiếm phòng
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for (Interval meeting : intervals) {
            // Chìa khóa: phòng sớm trống nhất đã trống chưa? ">=" vì (0,8),(8,10) không conflict
            if (!endTimes.isEmpty() && meeting.start >= endTimes.peek()) {
                endTimes.poll(); // tái sử dụng phòng đó
            }
            endTimes.add(meeting.end); // meeting hiện tại chiếm phòng
        }

        return endTimes.size();
    }
}