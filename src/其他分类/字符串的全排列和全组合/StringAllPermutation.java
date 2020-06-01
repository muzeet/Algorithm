package 其他分类.字符串的全排列和全组合;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路：
 * 把一个字符串看成两部分组成：第一部分为第一个字符，第二部分为后面的所有字符。
 *
 * 求整个字符串的排列，可以看出两步：首先求所有可能出现在第一个位置的字符，即把第一个字符和后面的所有字符交换；然后固定第一个字符，求后面所有字符的排序。此时仍把后面的字符看成两部分，第一个字符和后面的字符，然后重复上述步骤。（递归）
 *
 * 在后面的在线测试中，要求输入字符串可能有重复的字符，输出按照字典顺序。
 *
 *
 */
public class StringAllPermutation {

}
