import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountForwardTask implements Runnable {
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
        // Count from 0 up to 20
        for (int currentStep = 0; currentStep <= 20; currentStep++) {
            stateLock.lock();
            try {
                // Update shared state safely
                sharedCount = currentStep;

                // Keep output readable when multiple threads print
                synchronized (consoleLock) {
                    System.out.println("Forward counter reached value: " + sharedCount);
                }

                // Once 20 is reached, allow the second thread to continue
                if (currentStep == 20) {
                    upwardPassComplete = true;
                    readyToReverse.signal();
                }
            } finally {
                stateLock.unlock();
            }

            // Slow the output slightly so the thread behavior is easier to observe
            try {
                Thread.sleep(120);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                synchronized (consoleLock) {
                    System.out.println("Forward counting thread was interrupted.");
                }
                return;
            }
        }
    }
}