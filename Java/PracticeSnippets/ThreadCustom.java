package Java.PracticeSnippets;
class MythreadClass{
    
}
public class ThreadCustom {
    public static void main(String[] args) throws Exception{
        Runnable task = ()->{
            System.err.println("Task 1 is running ");
        };
        Thread t1 = new Thread(task, "TASK1");
        // t1.setName("TASK2");
        System.out.println(t1.threadId());
        t1.start();
        t1.join();
        System.out.println("Main Thread is Running Here");
    }
}
