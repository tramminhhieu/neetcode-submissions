
class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Bước 1: đăng ký MỌI chữ cái xuất hiện, kể cả chữ không có quan hệ nào
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Bước 2: so sánh từng cặp từ liền kề để lấy cạnh
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];

            // Trường hợp không hợp lệ: từ dài đứng trước prefix của chính nó
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int minLen = Math.min(w1.length(), w2.length());
            for (int j = 0; j < minLen; j++) {
                char from = w1.charAt(j), to = w2.charAt(j);
                if (from != to) {
                    // add() trả về true chỉ khi cạnh chưa tồn tại thì mới tăng in-degree
                    if (graph.get(from).add(to)) {
                        indegree.put(to, indegree.get(to) + 1);
                    }
                    break; // CHÌA KHÓA: chỉ chữ khác nhau đầu tiên mới cho thông tin
                }
            }
        }

        // Bước 3: Kahn's algorithm (BFS)
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) queue.offer(c);
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            result.append(cur);
            for (char next : graph.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) queue.offer(next);
            }
        }

        // Bước 4: chưa lấy đủ chữ thì đồ thị có chu trình
        return result.length() == indegree.size() ? result.toString() : "";
    }
}