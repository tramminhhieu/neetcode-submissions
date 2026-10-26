class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort theo start time tăng dần
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> result = new ArrayList<>();

        for (int[] curr : intervals) {
            // Nếu kết quả rỗng, hoặc curr không overlap với interval cuối trong result
            if (result.isEmpty() || result.get(result.size() - 1)[1] < curr[0]) {
                result.add(curr);
            } else {
                // Overlap: mở rộng end của interval cuối trong result
                int[] last = result.get(result.size() - 1);
                last[1] = Math.max(last[1], curr[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}