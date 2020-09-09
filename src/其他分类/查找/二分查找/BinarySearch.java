package 其他分类.查找.二分查找;

/**
 * 二分查找
 * 适用场景:
 * 1.已有序的数组或者部分排序的数组
 * 2.在有序数组中查找一个数字或者统计某个数字出现的次数
 *
 *
 */
public class BinarySearch {

    public int search(int[] array, int target) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("The input is invalid.");
        }

        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                return array[mid];
            }

        }
        return -1;
    }

    public int search2(int[] array, int target) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("The input is invalid.");
        }

        int low = 0;
        int high = array.length;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                return array[mid];
            }

        }
        return -1;
    }

}
