class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. Đi phải dọc hàng top
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            // 2. Đi xuống dọc cột right
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // 3. Đi trái dọc hàng bottom - CHỈ KHI còn hàng chưa đi
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // 4. Đi lên dọc cột left - CHỈ KHI còn cột chưa đi
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}