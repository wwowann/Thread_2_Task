import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        for (int i = 0; i < 10; i++) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Set<Callable<String>> callables = new HashSet<Callable<String>>();
            TimeUnit.SECONDS.sleep(2);
            int finalI = i + 1;
            callables.add(new Callable<String>() {
                public String call() throws Exception {
                    return "Привет! я поток 1. Это сообщение по счету " + finalI;
                }
            });
            callables.add(new Callable<String>() {
                public String call() throws Exception {
                    return "Привет! я поток 2. Это сообщение по счету " + finalI;
                }
            });
            callables.add(new Callable<String>() {
                public String call() throws Exception {
                    return "Привет! я поток 3. Это сообщение по счету " + finalI;
                }
            });
            callables.add(new Callable<String>() {
                public String call() throws Exception {
                    return "Привет! я поток 4. Это сообщение по счету " + finalI;
                }
            });
            List<Future<String>> futures = executorService.invokeAll(callables);

            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
            executorService.shutdown();
            System.out.println("");
        }
    }
}
