package jmmtroubles;

class MyRunnable3 implements Runnable {

    private static final int LIMIT = 15;
    private String threadName;
    private final boolean direction;

    MyRunnable3(boolean direction) {
        this.direction = direction;
    }

    public void run() {
        this.threadName = Thread.currentThread().getName();
        methodTwo();
    }


    private void methodTwo() {
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        /**
         * The localVariable1 reference will be stored in one copy per thread executing methodTwo().
         *  two threads executing this method will create SEPARATE Integer instances.
         *  The Integer objects created inside methodTwo() correspond to Object 1 and Object 5 in the diagram above.
         */
        Integer localVariable1 = new Integer(100);
//      -->  Integer (т.к. объект) помещается в HEAP

        System.out.printf("%s: initial value: %s%n", threadName, localVariable1);

        int incremetor = direction ? 1 : -1;
        int counter = 0;
        do {
            localVariable1 = localVariable1 + incremetor;
            counter++;
            System.out.printf("%s: %s%n", threadName, localVariable1);
        } while (counter < LIMIT);
        System.out.println("================================================================");

    }
}
