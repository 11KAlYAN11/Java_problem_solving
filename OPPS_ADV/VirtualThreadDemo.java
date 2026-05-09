package OPPS_ADV;

public class VirtualThreadDemo {

    public static void main(String[] args)
            throws Exception {

        /*
            Creating virtual thread
        */
        Thread.startVirtualThread(() -> {

            System.out.println(

                "Running in: "
                + Thread.currentThread()
            );
        });

        Thread.sleep(1000);
    }
}