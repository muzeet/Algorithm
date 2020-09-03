package Leetcode.根据身高重建队里406;
/**
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */

import java.util.*;

class Child {

    public Child(int w, int n)
    {
        this.weight = w;
        this.num = n;
    }

    int weight;
    int num;

    @Override
    public String toString() {
        return "[" + this.weight + "," + this.num + "]";
    }
}

class ReBuild {
    public int[][] reconstructQueue(int[][] people) {
        List<Child> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++)
        {
            list.add(new Child(people[i][0], people[i][1]));
        }
        List<Child> rebuildList = new ArrayList<>();

        Iterator<Child> iter = list.iterator();
        while (iter.hasNext())
        {
            Child child = iter.next();
            if (child.num == 0)
            {
                rebuildList.add(child);
                iter.remove();
            }
        }

        Collections.sort(list, new Comparator<Child>() {
            @Override
            public int compare(Child o1, Child o2) {
                if (o1.num == o2.num)
                {
                    return o1.weight - o2.weight;
                }
                else
                {
                    return o1.num - o2.num;
                }
            }
        });

        Collections.sort(rebuildList, new Comparator<Child>() {
            @Override
            public int compare(Child o1, Child o2) {
                return o1.weight - o2.weight;
            }
        });


        int count = 0;
        int index = 0;
        for (Child child : list) {
            int weight = child.weight;
            int num = child.num;
            count = 0;
            Iterator<Child> iterator = rebuildList.iterator();
            while (iterator.hasNext())
            {
                Child chi = iterator.next();
                if (weight <= chi.weight)
                {
                    if (++count == num+1)
                    {
                        index = rebuildList.indexOf(chi);
                        break;
                    }
                }
            }

            if (count == num +1)
            {
                rebuildList.add(index, child);
            }
            else
            {
                rebuildList.add(child);
            }
        }

        int[][] queue = new  int[people.length][2];
        for (int i = 0; i < queue.length; i++)
        {
            queue[i][0] = rebuildList.get(i).weight;
            queue[i][1] = rebuildList.get(i).num;
        }
        return queue;
    }

    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照先H高度降序，K个数升序排序
     * 2.遍历排序后的数组，根据K插入到K的位置上
     *
     * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue2(int[][] people) {
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[list.size()][2]);
    }
}