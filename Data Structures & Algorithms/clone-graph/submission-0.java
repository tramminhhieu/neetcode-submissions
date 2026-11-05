/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // node gốc → node clone; vừa là visited, vừa để tra cứu
    private final Map<Node, Node> clones = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // Đã clone rồi → trả lại đúng bản clone đó (chặn chu trình)
        if (clones.containsKey(node)) {
            return clones.get(node);
        }

        Node copy = new Node(node.val);
        clones.put(node, copy); // PHẢI put TRƯỚC khi đệ quy vào neighbors

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }
}