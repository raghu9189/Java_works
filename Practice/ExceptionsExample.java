import java.lang.Thread;
public class ExceptionsExample {
    public static void main(String[] args) throws InterruptedException {
        int x = 20;
        int y = 30;
        int z;

        // try catch
        // try{
        //     z = x/0;
        // } catch (Exception e) {
        //     System.out.println(e.toString());
        // }

        // try catch finally
        Thread.sleep(1000);
        try{
            z = x/0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }finally{
            System.out.println("I always get executed!");
        }

        try {
            throw new NullPointerException("demo");
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
