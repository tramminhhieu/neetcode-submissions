class MedianFinder {
    // Nửa nhỏ: max-heap, đỉnh = số lớn nhất của nửa nhỏ
    private final java.util.PriorityQueue<Integer> low;
    // Nửa lớn: min-heap, đỉnh = số nhỏ nhất của nửa lớn
    private final java.util.PriorityQueue<Integer> high;

    public MedianFinder() {
        low = new java.util.PriorityQueue<>((a, b) -> Integer.compare(b, a));
        high = new java.util.PriorityQueue<>();
    }

    public void addNum(int num) {
        // Đi qua low rồi đẩy max của low sang high
        // → mọi phần tử của low <= mọi phần tử của high
        low.offer(num);
        high.offer(low.poll());

        // Cân bằng: low được phép nhiều hơn high đúng 1
        if (high.size() > low.size()) {
            low.offer(high.poll());
        }
    }

    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        }
        return (low.peek() + high.peek()) / 2.0;
    }
}