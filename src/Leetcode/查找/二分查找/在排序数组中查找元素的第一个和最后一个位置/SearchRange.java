package Leetcode.查找.二分查找.在排序数组中查找元素的第一个和最后一个位置;

public class SearchRange {

    public int bSearch(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < nums[mid] || (isLeft && (target == nums[mid]))) {
                right = mid;
                //System.out.println("target<mid: " + "left: " + left + " right: " + right);
            } else {
                left = mid + 1;
                //System.out.println("target>mid: " + "left: " + left + " right: " + right);
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1 && nums[0] == target) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        int leftVal = bSearch(nums, target, true);
        if (leftVal == nums.length || nums[leftVal] != target) {
            return res;
        }

        // 如果已经找到了左侧值，则右侧值也一定会找到
        int right = bSearch(nums, target, false) - 1;
        res[0] = leftVal;
        res[1] = right;
        return res;

    }


}
