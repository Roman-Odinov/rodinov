package jmmtroubles;

class MyRunnable1 implements Runnable {

    private static final int LIMIT = 15;
    private String threadName;
    private final boolean direction;

    MyRunnable1(boolean direction) {
        this.direction = direction;
    }

    public void run() {
        this.threadName = Thread.currentThread().getName();
        methodOne();
    }

    private void methodOne() {
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        /**
         * Each thread executing methodOne() will CREATE ITS OWN COPY of localVariable1
         * on their respective THREAD STACKS.
         * The localVariable1 variables will be completely SEPARATED FROM EACH OTHER,
         * only living on each thread's thread stack.
         * One thread cannot see what changes another thread makes to its copy of localVariable1.
         */
        int localVariable1 = 45;    // primitive --> THREAD STACK
//      --> недоступна для других потоков

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
