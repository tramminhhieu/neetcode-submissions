class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Bước 1: đếm tần suất từng số — bạn đã làm đúng phần này
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Bước 2: tạo Min-Heap, so sánh theo tần suất (value)
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                    return a.getValue() - b.getValue();  // Min-Heap: nhỏ nhất luôn ở đầu
                }
            }
        );

        // Bước 3: duyệt map, giữ heap luôn có tối đa k phần tử
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();  // loại bỏ phần tử có tần suất NHỎ nhất
            }
        }

        // Bước 4: lấy các phần tử còn lại trong heap ra mảng kết quả
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }

        return res;
    }
}