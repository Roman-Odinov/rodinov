package start;

import models.*;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("first name", "first descr"));
        tracker.add(new Task("second name", "second descr"));

        /**
         * выведем список готовых элементов
         */
        for(Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }



    }

}
