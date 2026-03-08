import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountBackwardTask implements Runnable {
    // Shared number visible to both worker threads
    private static int sharedCount = 0;

    // Indicates whether the upward counting thread has completed
    private static boolean upwardPassComplete = false;

    // Lock used to protect shared state
    private static final Lock stateLock = new ReentrantLock();

    // Condition used to make the second thread wait until the first one finishes
    private static final Condition readyToReverse = stateLock.newCondition();

    // Separate monitor object for cleaner console printing
    private static final Object consoleLock = new Object();

    @Override
    public void run() {
        // Wait until the forward counting phase is done
        stateLock.lock();
        try {
            while (!upwardPassComplete) {
                readyToReverse.await();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            synchronized (consoleLock) {
                System.out.println("Backward counting thread was interrupted while waiting.");
            }
            return;
        } finally {
            stateLock.unlock();
        }

        // Count from 20 back down to 0
        for (int currentStep = 20; currentStep >= 0; currentStep--) {
            stateLock.lock();
            try {
                // Update shared state safely
                sharedCount = currentStep;

                // Print one complete line at a time
                synchronized (consoleLock) {
                    System.out.println("Reverse counter moved to value: " + sharedCount);
                }
            } finally {
                stateLock.unlock();
            }

            // Pause briefly for clearer output
            try {
                Thread.sleep(120);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                synchronized (consoleLock) {
                    System.out.println("Backward counting thread was interrupted.");
                }
                return;
            }
        }
    }
}