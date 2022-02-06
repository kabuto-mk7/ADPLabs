public class Threads2 {

    public static class Task02 implements Runnable {
        private final int delay;
        private final Thread givenThread;

        public Task02(int delay, Thread givenThread) {
            this.delay = delay;
            this.givenThread = givenThread;
        }

        @Override
        public void run() {
            try {
                joinThread();
                // printMsg();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void joinThread() throws InterruptedException {
            if (givenThread == null) {
                System.out.println("no thread to join...");
                printMsg();
            } else {
                givenThread.join();
                printMsg();
            }
        }

        public void printMsg() throws InterruptedException {
            Thread t = Thread.currentThread();
            String name = t.getName();
            int count = 0;

            while (count < 10) {
                System.out.println(name + " Count-" + count);
                count++;
                Thread.sleep(delay);

            }
        }
    }

    public static void main(final String args[]) {
        Thread t1 = new Thread(new Task02(500, null));
        Thread t2 = new Thread(new Task02(1000, t1));
        Thread t3 = new Thread(new Task02(1500, null));
        Thread t4 = new Thread(new Task02(2000, t3));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}