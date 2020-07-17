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
        char start = str[pos];
        for (int i = pos; i < str.length; i++) {
            str[pos] = str[i];
            str[i] = start;
            getPermutation(str, pos + 1);
            start = str[pos];
            str[pos] = str[i];
            str[i] = start;
        }
    }


}
