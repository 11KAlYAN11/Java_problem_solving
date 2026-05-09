package Threads;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {

    public static void main(String[] args) {

        /*
            Thread-safe ArrayList
        */
        CopyOnWriteArrayList<String> list =
                new CopyOnWriteArrayList<>();

        list.add("Java");
        list.add("Spring");
        list.add("Kafka");



        /*
            Safe iteration even during modification
        */
        for(String s : list) {

            System.out.println(s);

            /*
                Modifying while iterating.

                Normally ArrayList throws:
                ConcurrentModificationException

                But CopyOnWriteArrayList works safely.
            */
            list.add("New");
        }

        System.out.println(list);
    }
}
