package 其他分类.字符串的全排列和全组合;

import java.util.HashSet;
import java.util.Set;

public class Permutation {
    Set<String> set = new HashSet<>();

    public void getPermutation2(String str, int index) {
        if (str.length() - 1 == index) {
            set.add(str);
            System.out.println("-----");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String dst = str;
            char first = dst.charAt(i);

            String second = i < str.length() - 1 ? dst.substring(0, i) + dst.substring(i + 1, dst.length()) : dst.substring(0, i);

            System.out.println("first: " + first + " second: " + second);
            String replaceStr = first + second;
            System.out.println("replaceStr: " + replaceStr + " index: " + index);

            getPermutation2(replaceStr, index + 1);
        }
    }


    public void getPermutation(String str, int index) {
        if (str.length() - 1 == index) {
            set.add(str);
            System.out.println("-----");
            return;
        }

        for (int i = index; i < str.length(); i++) {
            String dst = str;
            char target = dst.charAt(index);
            char indexChar = dst.charAt(i);
            String part1 = "";
            if (index > 0) {
                part1 = dst.substring(0, index);
            }

            String mid = "";
            if (index + 1 < i) {
                mid = dst.substring(index + 1, i);
            }

            String last = "";
            if (i < str.length() - 1) {
                last = dst.substring(i + 1, str.length());
                //String second = i < str.length() - 1 ? dst.substring(0, i) + dst.substring(i + 1, dst.length()) : dst.substring(0, i);
            }

            System.out.println("part1: " + part1 + " target: " + target + " indexChar: " + indexChar + " mid: " + mid+ " last: " + last);
            // System.out.println("first: " + first + " second: " + second);
            String replaceStr = (i != index)? part1 + indexChar + mid + target + last : part1  + mid + target + last;
            System.out.println("replaceStr: " + replaceStr + " index: " + index);

            getPermutation(replaceStr, index + 1);
        }
    }

    public void getPermutation3(String str, int index) {
        if (str.length() - 1 == index) {
            set.add(str);
            System.out.println("-----");
            return;
        }

        for (int i = index; i < str.length(); i++) {
            String dst = str;
            char target = dst.charAt(index);
            char indexChar = dst.charAt(i);
            StringBuilder builder = new StringBuilder(dst);
            builder.replace(index, index + 1, String.valueOf(indexChar));
            System.out.println("first: " + builder.toString());
            builder.replace(i, i + 1,  String.valueOf(target));
            String replaceStr = builder.toString();
            System.out.println("replaceStr: " + replaceStr + " index: " + index);

            getPermutation3(replaceStr, index + 1);
        }
    }


    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.getPermutation3("abcde", 0);
        for (String s : permutation.set) {
            System.out.println(s);
        }
        System.out.println(permutation.set.size());
    }
}
