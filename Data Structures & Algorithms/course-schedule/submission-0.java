class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Xây adjacency list: graph.get(b) = các môn được b mở khóa
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            graph.get(prereq).add(course);   // cạnh prereq → course
            indegree[course]++;              // course có thêm 1 môn tiên quyết
        }

        // Bắt đầu từ các môn không cần tiên quyết
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int taken = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            taken++;
            for (int next : graph.get(current)) {
                indegree[next]--;
                if (indegree[next] == 0) {   // đã đủ tiên quyết → học được
                    queue.offer(next);
                }
            }
        }
        // Các môn trong chu trình không bao giờ có indegree về 0
        return taken == numCourses;
    }
}