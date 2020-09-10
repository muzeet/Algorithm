package 可信.TLV;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * TLV(Tag-Length-Value), Tag: 标签域, Length: 长度域, Value: 内容域
 *
 * TLV码流格式: 00 01 00 00 00 01 6f
 * 码流中前2个字节00 01为T, 接着4字节 00 00 00 01为L, 6f为V, 字节均为16进制
 *
 *
 *
 */
public class TLV {
    public static String changeChar(char ch) {
        char res = ch;
        if (ch >= 'a' && ch <= 'z') {
            res = (char)('A' + ch - 'a');
        } else if (ch >= 'A' && ch <= 'Z') {
            res = (char)('a' + ch - 'A');
        }
        return String.valueOf(res);
    }
    public static String getPart(int start, int end, List<String> bitStream) {
        String res = "";
        for (int i = start; i <= end; i++) {
            res += bitStream.get(i);
        }
        return res;
    }
    public static String parser(List<String> bitStream) {
        if (bitStream == null || bitStream.size() <=6) {
            return "{T:0,L:0,V:}";
        }

        String t = getPart(0, 1, bitStream);
        String l = getPart(2, 5, bitStream);
        long tVal = Integer.parseInt(t, 16);
        long lVal = Integer.parseInt(l, 16);
        if (lVal + 6 > bitStream.size() || bitStream.size() > 300) {
            return "{T:" + tVal +",L:" + lVal + ",V:Invalid}";
        }

        String valStr = "";
        for (int i = 6; i < 6 + lVal; i++) {
            String val = bitStream.get(i);
            // 00 2个16进制数. 一个字节, 不会溢出
            int intVal = Integer.parseInt(val, 16);
            if (intVal >= 32 && intVal <= 126) {
                valStr += changeChar((char)intVal);
            }
        }
        return "{T:" + tVal +",L:" + lVal + ",V:" + valStr + "}";

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> bitStream = new LinkedList<>();
        // 结束循环, windows平台ctrl+Z, linux平台 ctrl + D
        while (scanner.hasNext()) {
            String str = scanner.next();
            bitStream.add(str);
            System.out.println(str);
        }
        System.out.println("--------");
        scanner.close();
        String res = parser(bitStream);
        System.out.println(res);
    }
}
