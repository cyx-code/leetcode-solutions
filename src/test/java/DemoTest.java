import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                if (i > 10) {
                    list1.add(10);
                } else {
                    list1.add(i);
                }
                list.add(list1);
                list1 = new ArrayList<>();
            } else {
                if (i > 10) {
                    list1.add(i % 10);
                } else {
                    list1.add(i);
                }
            }
        }
        CopyOnWriteArraySet<Object> safeSet = new CopyOnWriteArraySet<>();

//        System.out.println(list.size());
        Set<Integer> set = new HashSet<>();
        list.forEach(l -> {
            executorService.execute(() -> {
                l.forEach(ll -> {
                    set.add(ll);
                    safeSet.add(ll);
                });
                countDownLatch.countDown();
            });

        });
        try {
            countDownLatch.await();
            System.out.println("unsafe:" +set.size());
            set.forEach(s -> {
                System.out.print(s + ",");
            });
            System.out.println();
            System.out.println("safe:" + safeSet.size());
            safeSet.forEach(safe -> {
                System.out.print(safe + ",");
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
