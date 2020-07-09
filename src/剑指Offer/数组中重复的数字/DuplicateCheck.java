package 剑指Offer.数组中重复的数字;

/**
 * 题目描述
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应的输出是第一个重复的数字 2 或 3 。
 *
 * 测试用例
 * 长度为n的数组包含一个或多个重复的数字。
 * 数组中不包含重复的数字。
 * 无效输入测试用例（输入数组为空；程度为n的数组中包含 0 到 n-1之外的数字）
 *
 * 解题思路
 * 差（时间复杂度为O(nlogn)，空间复杂度为O(1)）
 * 先对数组排序，然后从头扫描排序后的数组就可以了。
 *
 * 中（时间复杂度为O(n)，空间复杂度为O(n)）
 * 从头到尾按顺序扫描数组的每个数字，每扫描到一个数字的时候就判断该哈希表是否已经存在该数字，如果哈希表还没有这个数字，就把它加入到哈希表中，如果哈希表已经有这个数字，就找到了一个重复的数字。
 *
 * 好（时间复杂度为O(n)，空间复杂度为O(1)）
 * 关键：这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素放到第 i 个位置上。
 *
 * 从头到尾依次扫描这个数字中的每个数字，当扫描到下标为i的数字，首先比较这个数字（用m表示）是不是等于i，如果是，则继续扫描下一个，如果不是，就就拿它和第m个数字比较，如果它和第m个数字相等，就找到了一个重复的数字；如果不相等，就把第i个数字与第m个数字交换，把m放到属于它的位置，接下来再重复这个比较，交换的过程，直到我们发现一个重复的数字。
 *
 */
public class DuplicateCheck {


    /**
     * @param intArray    输入数组
     * @param duplicaiton 将首次找到的重复数字利用duplicaiton[0] = ?存入数组
     * @return 如果输入数组无效返回false，duplicaiton[0]=-1
     * @Description 找出数组中重复的数字
     */
    public static boolean findDuplicate(int[] intArray, int[] duplicaiton) {
        // 数组为空
        if (intArray.length == 0) {
            duplicaiton[0] = -1;
            return false;
        }

        // 数组元素非法
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < 0 || intArray[i] >= intArray.length) {
                duplicaiton[0] = -1;
                return false;
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            // 如果数组i位置的元素放入元素对应位置
            while (i != intArray[i]) {
                int temp = intArray[i];
                if (intArray[temp] == temp) {
                  duplicaiton[0] = temp;
                  return true;
                }

                intArray[i] = intArray[temp];
                intArray[temp] = temp;
            }
        }

        duplicaiton[0] = -1;
        return false;

    }

}
