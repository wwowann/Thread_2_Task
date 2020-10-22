public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(1000);
                System.out.printf("Я %s Всем привет!\n", getName());
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("Я %s завершен\n", getName());
        }
    }
}
