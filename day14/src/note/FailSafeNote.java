package note;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description 快速失败和安全失败
 * @Author Noby
 * @Date 2023/3/16 19:40
 */
public class FailSafeNote {
    public static void main(String[] args) {
        //region 快速失败，基本接触到的大部分集合都是快速失败
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            list.remove(element); // 在遍历过程中修改集合，会触发快速失败
        }
        //endregion


        //region 安全失败
//        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
//
//        for (int i = 0; i < 100; i++) {
//            map.put(i, i);
//        }
//
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 50; i++) {
//                map.computeIfPresent(i, (key, value) -> value + 1);
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (int i = 50; i < 100; i++) {
//                map.computeIfPresent(i, (key, value) -> value + 1);
//            }
//        });
//
//        t1.start();
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //endregion
    }
}
