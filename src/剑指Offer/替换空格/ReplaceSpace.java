package 剑指Offer.替换空格;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 解法一：用Java自带的函数str.toString().replace(" ","%20")。
 * 解法二：在当前字符串上进行替换。
 * 先计算替换后的字符串需要多大的空间，并对原字符串空间进行扩容；
 * 从后往前替换字符串的话，每个字符串只需要移动一次；
 * 如果从前往后，每个字符串需要多次移动，效率较低。
 * 解法三：开辟一个新的字符串。
 *
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int spaceLens = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceLens++;
            }
        }

        int oldLens = str.length();
        int newLens = spaceLens * 2 + oldLens;
        str.setLength(newLens);
        // 2个指针, 分别指向末尾
        int oldIndex = oldLens - 1;
        int newIndex = newLens - 1;
        // 当替换完所有的空格后,newIndex = oldIndex. 就不再需要替换了
        while (oldIndex >= 0 && newIndex > oldIndex) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
            oldIndex--;
        }
        return str.toString();
    }

}

