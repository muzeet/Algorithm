package 其他分类.字符串的全排列和全组合;


public class Permutation {

    public static void permutation(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        getPermutation(str.toCharArray(), 0);
    }

    public static void getPermutation(char[] str, int pos) {
        // 如果達到這最後
        if (pos == str.length - 1) {
            System.out.println(str);
            return;
        }
        // 每次固定前面一位, 然后递归求后面在子问题,依次求子问题的子问题, 首先被替换的也是当前循环元素替换自己,
        // 子问题内部当前元素替换自己, 然后i+1, 替换不同的元素, 首先被反向替換回来的是子问题.
        for (int i = pos; i < str.length; i++) {
            char start = str[pos];
            str[pos] = str[i];
            str[i] = start;
            System.out.printf("%s, pos=%d str[%d]: %s, i=%d str[%d]: %s\n", String.valueOf(str), pos, pos, String.valueOf(str[pos]), i, i, String.valueOf(str[i]));
            getPermutation(str, pos + 1);
            start = str[pos];
            str[pos] = str[i];
            str[i] = start;
            System.out.println(String.valueOf(str) + " after pos " + pos + " replace");
        }
    }

    public static void main(String[] args) {
        String str = "abcd";
        permutation(str);
    }


}
