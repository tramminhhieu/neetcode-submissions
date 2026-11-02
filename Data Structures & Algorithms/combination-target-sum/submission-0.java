class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort để có thể cắt nhánh sớm
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int remain, int start,
                           List<Integer> path, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(path)); // CHÌA KHÓA: phải copy path
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remain) break;        // pruning: số sau còn lớn hơn
            path.add(nums[i]);                  // choose
            backtrack(nums, remain - nums[i], i, path, result); // explore: truyền i (được dùng lại)
            path.remove(path.size() - 1);       // un-choose
        }
    }
}