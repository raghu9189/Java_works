package Java.PracticeSnippets;

class MyThreadA extends Thread{
    public void run(){
        System.out.println("Started Thread A");
        for (int i = 0; i < 10; i++) {
            System.out.println("From thread A: " + i);
        }
        System.out.println("Ended Thread A");
    }
}

class MyThreadB extends Thread{
    public void run(){
        System.out.println("Started Thread B");
        for (int i = 0; i < 10; i++) {
            System.out.println("From thread B: " + i);
        }
        System.out.println("Ended Thread B");
    }
}

class MyThreadC extends Thread{
    public void run(){
        System.out.println("Started Thread C");
        for (int i = 0; i < 10; i++) {
            System.out.println("From thread C: " + i);
        }
        System.out.println("Ended Thread C");
    }
}

public class ThreadPriorityDemo {
    public static void main(String[] args) throws Exception {
        MyThreadA threadA = new MyThreadA();
        MyThreadB threadB = new MyThreadB();
        MyThreadC threadC = new MyThreadC();

        threadC.setPriority(Thread.MAX_PRIORITY);
        threadB.setPriority(Thread.NORM_PRIORITY);
        threadA.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Start thread A");
        threadA.start();

        System.out.println("Start thread B");
        threadB.start();

        System.out.println("Start thread C");
        threadC.start();

        System.out.println("End of main thread");
        
    }
}
