package other;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author sunwenchi
 * @Description :
 * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 * @Date 15:10 2021/3/20
 **/
public class LRUDemo {
    public static void main(String[] args) {

        LRUCaches lruCaches = new LRUCaches(3);
        lruCaches.put("1", 1);
        lruCaches.put("2", 21);
        lruCaches.put("3", 31);
        lruCaches.put("4", 41);

        System.out.println(lruCaches.size());
        System.out.println(lruCaches.get("1"));

    }

    public int[] LRU(int[][] operators, int k) {
        if (k <= 0) {
            return null;
        }

        LRUCaches lruCaches = new LRUCaches(k);

        ArrayList<Integer> lruResult = new ArrayList<Integer>();

        for (int i = 0; i < operators.length; i++) {
            int[] operator = operators[i];
            if (operator[0] == 1) {
                lruCaches.put(operator[1], operator[2]);
            }
            if (operator[0] == 2) {
                lruResult.add(lruCaches.get(operator[1]));
            }
        }
        int[] intResult = new int[lruResult.size()];
        for (int i = 0; i < intResult.length; i++) {
            intResult[i] = lruResult.get(i);
        }
        return intResult;
    }


    private static class LRUCaches extends LinkedHashMap {

        private int capacity;

        public LRUCaches(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            return (int) super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }

}
