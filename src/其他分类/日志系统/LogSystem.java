package 其他分类.日志系统;

import java.util.*;


public class LogSystem {
    String[] grap = {"Year", "Month", "Day", "Hour", "Minute", "Second"};
    int[] indice = {4, 7, 10, 13, 16, 19};

    Map<Integer, String> store = null;
    public LogSystem() {
        store = new HashMap<>();
    }
    public void put(int id, String timestamp) {
        store.put(id, timestamp);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();
        Set<Map.Entry<Integer, String>> entrys = store.entrySet();
        List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(entrys);
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        int index = -1;
        for (int i = 0; i < grap.length; i++) {
            if (grap[i].equals(gra)) {
                index = indice[i];
            }
        }
        if (index == -1) {
            return res;
        }
        for (int i = 0; i < list.size(); i++) {
            String log = list.get(i).getValue();
            String sub = log.substring(0, index);
            if (sub.compareTo(s.substring(0, index)) >= 0 && sub.compareTo(e.substring(0, index)) <= 0) {
                res.add(list.get(i).getKey());
            }

        }
        return res;
    }
    public static int test(String str1, String str2) {
        int res =  str1.compareTo(str2);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        test("a", "c");
    }
}
