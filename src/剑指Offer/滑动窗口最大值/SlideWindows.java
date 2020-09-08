package 剑指Offer.滑动窗口最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 思路: 单调队列
 *
 *
 */
public class SlideWindows {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            int[] res = new int[0];
            return res;
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // Deque<Integer> queue = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        // 维持队列队首为最大元素，递减，对尾比当前元素小，则删除
        // 窗口还未构成
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }

        res[0] = queue.getFirst();

        // 窗口已形成
        for (int i = k; i < n; i++) {
            if (nums[i - k] == queue.getFirst()) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            res[i - k + 1] = queue.getFirst();
        }
        return res;
    }
}















