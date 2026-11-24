public class Codec {

    private static final String NULL_MARK = "#";
    private static final String DELIM = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDfs(root, sb);
        return sb.toString();
    }

    private void serializeDfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            // Ghi null để giữ thông tin cấu trúc (chìa khóa của bài)
            sb.append(NULL_MARK).append(DELIM);
            return;
        }
        sb.append(node.val).append(DELIM);   // gốc
        serializeDfs(node.left, sb);          // trái
        serializeDfs(node.right, sb);         // phải
    }

    private int idx; // con trỏ đọc token, để field vì Java pass-by-value

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(DELIM);
        idx = 0; // reset phòng khi object Codec được dùng lại
        return deserializeDfs(tokens);
    }

    private TreeNode deserializeDfs(String[] tokens) {
        String token = tokens[idx++];

        if (token.equals(NULL_MARK)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(token));
        // THỨ TỰ QUAN TRỌNG: trái trước, phải sau (khớp với lúc serialize)
        node.left = deserializeDfs(tokens);
        node.right = deserializeDfs(tokens);
        return node;
    }
}