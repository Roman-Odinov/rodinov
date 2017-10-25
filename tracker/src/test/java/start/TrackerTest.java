package start;

import models.Item;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    Tracker tracker = new Tracker();

    @Test
    public void testAllMethods() throws Exception {
        Item[] items = new Item[3];
        items[0] = new Item("1st item", "1st description", 11011);
        items[1] = new Item("another item", "2nd description", 11022);
        items[2] = new Item("another item", "3rd description", 33333);


        /**
         * .add()
         */
        tracker.add(items[0]);
        tracker.add(items[1]);
        tracker.add(items[2]);


        /**
         * .getAll()
         */
        assertEquals(items[0], tracker.getAll()[0]);
        assertEquals(items[1], tracker.getAll()[1]);
        assertEquals(items[2], tracker.getAll()[2]);


        /**
         * .findByName()
         */
        // у нас 2 совпадающих по имени "another item" элемента: items[1], items[2]
        Item[] itemsToCompareTo = { items[1], items[2] };   //  то, с чем будем сравнивать
        Item[] foundItems = tracker.findByName("another item");    // то, что получаем в методе

        assertThat(foundItems, is(itemsToCompareTo));

        // распечатаем
        for (Item theitem : foundItems){
            System.out.println("name: " + theitem.getName() + "; id = " + theitem.getId());
        }
        System.out.println("=============================================================");


        /**
         * .update()
         */

        //// ПРОВРЕРКА ПРИ ВАЛИДНОМ id

        // возьмем первый элемент и сохраним его id
        String gottenId = tracker.items[0].getId();
        System.out.println("gottenId " + gottenId);

        // типа "модифицированная" первая заявка: изменим description
        Item newItem = new Item("1st item", "Updated description", 11011);
        System.out.println("newItem Id: " + newItem.getId());
        // установим ей такой же id как и у элемента, который хотим обновить
        newItem.setId(gottenId);

        // перед тем как обновить проверим, что оригинал не изменился
        assertThat(newItem, not(tracker.items[0]));

        tracker.update(newItem);                             // обновим
        // а теперь проверим, что оригинал изменился
        assertThat(newItem, is(tracker.items[0]));


        //// ПРОВЕРКА ПРИ НЕСУЩЕСТВУЮЩЕМ id

        // попробуем поставить id , несуществующий в списке
        Item incorrectItem = new Item("super", "descr", 3432423);
        String incorrectID = "123456789";
        incorrectItem.setId(incorrectID);
        tracker.update(incorrectItem);

        // проверим, что оригинал не изменился
        for (int index = 0; index < tracker.position; index++) {
            assertThat(incorrectID, not(tracker.items[index].getId()));
        }


        // распечатаем
        // в местном массиве ничто не должно поменяться:
        for (Item theitem : items) {
            System.out.println(theitem.getName() + "; " + theitem.getDescription() + "; " + theitem.getId());
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // в tracker первый элемент заменен
        for (int index = 0; index < tracker.position; index++) {
            System.out.println(tracker.items[index].getName() + "; " + tracker.items[index].getDescription() + "; "
                    + tracker.items[index].getId());
        }
        System.out.println("=============================================================");


        /**
         * findById()
         */
        // возьмем второй элемент: tracker.items[1]
        String obtainedId = tracker.items[1].getId();    // должен быть элемент с description == "2nd description"
        System.out.println("obtainedId: " + obtainedId);

        //// ПРОВРЕРКА ПРИ ВАЛИДНОМ id
        Item itemFoundById = tracker.findById(obtainedId);   // itemFoundById - найденный элемент
        System.out.println(itemFoundById.getDescription());
        assertEquals(tracker.items[1], itemFoundById);

        //// ПРОВЕРКА ПРИ НЕСУЩЕСТВУЮЩЕМ id
        itemFoundById = tracker.findById("1234567890");   // такого Id не существует в массиве
        assertEquals(null, itemFoundById);

        System.out.println("=============================================================");


        /**
         * delete()
         */
        // удаляем второй элемент,
        // список для сравнения состоит из первого и третьего элемента:
        itemsToCompareTo = new Item[]{ tracker.items[0], tracker.items[2] };

        // удалим второй по счету элемент
        tracker.delete(tracker.items[1]);

        assertThat(tracker.getAll(), is(itemsToCompareTo));

        // распечатаем массив
        for (int index = 0; index < tracker.position; index++) {
            System.out.println(tracker.items[index].getName() + "; " + tracker.items[index].getDescription() + "; "
                    + tracker.items[index].getId());
        }


        /**
         * again just in case
         * .add()
         */
        tracker.add(items[0]);


    }

}