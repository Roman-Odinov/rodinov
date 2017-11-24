package jmmtroubles;

public class MySharedObject {

    //STATIC variable pointing to instance of MySharedObject
    public static final MySharedObject SHARED_INSTANCE =
            new MySharedObject();

    //member variables pointing to two objects on the heap
    /**
     * Notice how the MySharedObject class contains two MEMBER VARIABLES too.
     * The member variables themselves are stored on the HEAP along with the object.
     * The two member variables point to two other Integer objects.
     * These Integer objects correspond to Object 2 and Object 4 in the diagram above.
     */
    public Integer object2 = new Integer(22);
    public Integer object4 = new Integer(44);

    /**
     * LONG type (P.S> primitive):
     * Since these variables are MEMBER VARIABLES, they are still stored on the HEAP along with the object.
     * (Only local variables are stored on the thread stack.)
     */
    public long member1 = 5;
    public long member2 = 67890;
}

