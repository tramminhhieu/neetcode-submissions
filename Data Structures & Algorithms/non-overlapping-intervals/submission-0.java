class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Chìa khóa: sort theo END, không phải start
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int count = 0; // số interval cần xóa
        int lastEnd = intervals[0][1]; // end của interval được giữ lại gần nhất

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                // Overlap: xóa interval hiện tại (vì nó end muộn hơn hoặc bằng,
                // do đã sort theo end nên luôn là lựa chọn xóa tốt nhất)
                count++;
            } else {
                // Không overlap: giữ lại, cập nhật lastEnd
                lastEnd = intervals[i][1];
            }
        }

        return count;
    }
}