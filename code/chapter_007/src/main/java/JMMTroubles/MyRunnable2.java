package JMMTroubles;

class MyRunnable2 implements Runnable {

    private static final int mustBe = 5;
    private String threadName;

    public void run() {
        this.threadName = Thread.currentThread().getName();
        methodOne();
    }

    private void methodOne() {
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        /**
         * Each thread executing methodOne() will CREATE THEIR OWN COPY of localVariable2.
         * However, the two DIFFERENT COPIES of localVariable2 both end up pointing to THE SAME OBJECT on the heap:
         *
         * The code sets localVariable2 to point to an object referenced by a STATIC variable.
         * There is only one copy of a STATIC variable and this copy is stored on the HEAP.
         *
         * The MySharedObject instance is also stored on the HEAP. It corresponds to Object 3 in the diagram above.
         */
        MySharedObject localVariable2 = MySharedObject.sharedInstance; // object reference -- > HEAP
        // --> доступна для изменения всеми потоками

//        System.out.printf("%s:%n", methodName);

        System.out.printf("%s: начальное значение %s%n", threadName, localVariable2.member1);
        System.out.printf("%s: собираемся поменять значение, проверка... %n", threadName);
        if (localVariable2.member1 == mustBe) {
            localVariable2.member1 += 1;
            System.out.printf("%s: всё в порядке, меняем...%n", threadName);
            System.out.printf("%s: changed %s%n", threadName, localVariable2.member1);
        } else {
            System.out.printf("%s: значение уже было изменено другим потоком! (равно %s)%n",
                    threadName, localVariable2.member1);
        }
        System.out.println("================================================================");

    }

}
