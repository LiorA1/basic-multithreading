import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main
{


    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        Worker worker = new Worker();
        worker.main();

        System.out.println("finished with Regular worker..");

        WorkerWithSyncOnMethods worker2 = new WorkerWithSyncOnMethods();
        worker2.main();

        System.out.println("finished with sync on methods");

        WorkerWithSyncBlocks worker3 = new WorkerWithSyncBlocks();
        worker3.main();

        System.out.println("finish with sync block worker..");

    }


}


