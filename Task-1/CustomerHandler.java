public class CustomerHandler {
    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        customerHandlerThread c = new customerHandlerThread();
        c.run();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Runtime: " + elapsedTime + " miliseconds");
    }
}
