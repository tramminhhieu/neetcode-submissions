class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // Tìm dấu '#' đầu tiên kể từ vị trí i
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            // Đọc độ dài từ i đến j-1
            int length = Integer.parseInt(str.substring(i, j));
            // Nội dung nằm từ j+1, dài 'length' ký tự
            res.add(str.substring(j + 1, j + 1 + length));
            // Nhảy tới đầu chuỗi tiếp theo
            i = j + 1 + length;
        }
        return res;
    }
}