public class SequentialCounterDemo {

    public static void main(String[] args) {
        // Create both worker threads
        Thread upwardWorker = new Thread(new CountForwardTask(), "UpwardWorker");
        Thread downwardWorker = new Thread(new CountBackwardTask(), "DownwardWorker");

        // Start both threads
        upwardWorker.start();
        downwardWorker.start();

        // Wait for both threads to finish before ending main
        try {
            upwardWorker.join();
            downwardWorker.join();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Main execution was interrupted before completion.");
        }

        System.out.println("All counting activity has finished.");
    }
}