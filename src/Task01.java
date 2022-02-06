public class Task01 implements Runnable{

    public static int delay = 0;

    public Task01(int delay){
        Task01.delay = delay;
    }

    public void run() {
        try {
            printMsg();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public void printMsg()throws InterruptedException{
        Thread t = Thread.currentThread();
        String name = t.getName();
        int count = 0;
        while (count <= 10){
            System.out.println(name + " Count-" + count);
            count++;
            Thread.sleep(delay);
        }
        }

    public static void main(String args[]) 
        throws InterruptedException{
        Thread t1 = new Thread( new Task01(500));
        t1.start();
        Thread t2 = new Thread( new Task01(1000));
        t2.start();
        Thread t3 = new Thread( new Task01(2000));
        t3.start();
        Thread t4 = new Thread( new Task01(3000));
        t4.start();
    }
}