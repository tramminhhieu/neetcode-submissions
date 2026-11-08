class Solution {
    private int[] parent;
    private int[] rank;

    public boolean validTree(int n, int[][] edges) {
        // Cây n đỉnh phải có đúng n - 1 cạnh
        if (edges.length != n - 1) return false;

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;  // mỗi đỉnh tự là gốc

        for (int[] edge : edges) {
            // u, v đã cùng nhóm → cạnh này khép kín một chu trình
            if (!union(edge[0], edge[1])) return false;
        }
        // n-1 cạnh + không chu trình → liên thông → là cây
        return true;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);   // path compression: nối thẳng về gốc
        }
        return parent[x];
    }

    // Trả về false nếu x, y đã cùng nhóm (tức là có chu trình)
    private boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false;

        // union by rank: gắn cây thấp vào dưới cây cao để cây không bị dài
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}