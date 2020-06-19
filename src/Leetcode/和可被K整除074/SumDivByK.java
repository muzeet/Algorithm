package Leetcode.和可被K整除074;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 *
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 *
 *
 *
 * 思路： 前缀和
 * 我们令 P[i] = A[0] + A[1] + ... + A[i]P[i]=A[0]+A[1]+...+A[i]。那么每个连续子数组的和sum(i,j) 就可以写成 P[j] - P[i-1]（其中 0 < i < j0<i<j）的形式。此时，判断子数组的和能否被 K 整除就等价于判断 (P[j] - P[i-1]) mod K == (P[j]−P[i−1])modK==0，根据 同余定理，只要 P[j] \bmod K == P[i-1] \bmod KP[j]modK==P[i−1]modK，就可以保证上面的等式成立。
 *
 */


public class SumDivByK {


    public int subarraysDivByK(int[] A, int K) {
        // 记录前缀和被K求模的值， 与对应的个数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int arrays = 0;
        for (int num: A) {
            sum += num;
            // 同模和同余的区别
            // 会出现k = 5, 则 -1 和 4 同模
            int mod = (sum % K + K) % K;
            if (map.containsKey(mod)) {
                int ans = map.get(mod);
                arrays += ans;
                map.put(mod, ans + 1);
            }
            else {
                map.put(mod, 1);
            }
        }
        return arrays;
    }

    public static void main(String[] args) {
        SumDivByK sumDivByK = new SumDivByK();
        int[] a = {4,5,0,-2,-3,1};
        System.out.println(sumDivByK.subarraysDivByK(a, 5));

    }


}
