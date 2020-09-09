package Leetcode.查找.二分查找.在排序数组中查找元素的第一个和最后一个位置;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchRangeTest {

    @Test
    public void searchRange() {
       int[] array = {5,7,7,8,8,10};
       int target = 8;
       SearchRange searchRange = new SearchRange();
       int[] res = searchRange.searchRange(array, target);
       System.out.println(res[0] + " : " + res[1]);
    }
}