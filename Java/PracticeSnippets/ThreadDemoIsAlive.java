
package Java.PracticeSnippets;
/**
 *  
 */
public class ThreadDemoIsAlive {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        });

        t1.start();
        t2.start();
        System.out.println("Is Alive T1: " + t1.isAlive());  
        t1.join();
        t2.join();
        System.out.println("Is Alive T1: " + t1.isAlive());  
        System.out.println("Bye");

    }
}
