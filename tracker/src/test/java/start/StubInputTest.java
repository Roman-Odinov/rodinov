package start;

import models.Item;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * 2. В классе StubInputTest написать JUnit тесты, использующие класс StubInput (из видео) для эмуляции поведения пользователя.
 * 3. Тест-методы должны вместо пользователя выбирать пункты меню, вводить необходимые данные и выходить из приложения,
 * после этого проверить изменение данных в Tracker;
 * 4. Необходимо написать тесты на все пункты меню.
 *
 * Пример:
 * В StubInput задаём последовательность выбора {0, "name", "desc", 6}, где 0 это выбор элемента меню - добавление заявки,
 * name и desc - имя автора и описание заявки, 6 - это выход.
 * После этого проверяем, что в трекере появился новый объект Item с именем name и описанием desc.
 *
 */
public class StubInputTest {

    Tracker tracker = new Tracker();
    @Test
    public void InputTest() throws Exception {
        /**
         * Создаём объект Tracker;
         * добавляем в трекер тестовые заявки;
         */
        String testName0 = "TASK0";
        String testDescr0 = "DESCR0";
        long fakeTime0 = 1333232;
        Item item = new Item(testName0, testDescr0, fakeTime0);
        tracker.add(item);
        String ID0 = tracker.items[0].getId();

        assertThat(tracker.getAll()[0].getName(), is(testName0)); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.


        String testName1 = "task1";
        String testDescr1 = "desc1";
        String testName2 = "task";
        String testDescr2 = "desc2";
        String testName3 = "task";
        String testDescr3 = "desc3";
        /**
         * действия виртуального пользователя
         */
        String[] answers = {
                "1",        // Show all items
                "0",        // Add new Item
                testName1,    // task's name
                testDescr1,    // description
                "0",        // Add new Item
                testName2,    // task's name
                testDescr2,    // description
                "0",        // Add new Item
                testName3,    // task's name
                testDescr3,    // description
                "1",        // Show all items
                "6"         // Exit
        };
        /**
         * Создаём объект StubInput, в который передаём массив из последовательности выбора действий виртуального пользователя;
         */
        new StartUI(new StubInput(answers), tracker).init();

        assertThat(tracker.getAll()[1].getName(), is(testName1)); // проверяем, что элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.getAll()[2].getName(), is(testName2)); // проверяем, что элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.getAll()[3].getName(), is(testName3)); // проверяем, что элемент массива в трекере содержит имя, введённое при эмуляции.

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        String testName4 = "changed task1";
        answers = new String[]{
                "2",    // Edit item
                "4",    // item's serial number - doesn`t exist
                "2",    // Edit item
                "1",    // item's serial number - exists
                testName4,     // new task's name
                "changed desc1",      // new description
                "1",    // Show all items
                "6"     // Exit
        };
        new StartUI(new StubInput(answers), tracker).init();

        assertThat(tracker.getAll()[1].getName(), is(testName4)); // проверяем, что элемент массива в трекере содержит имя, введённое при эмуляции.


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        answers = new String[]{
                "4",    // Find item by Id
                ID0,     // id from preset item
                "5",    // Find items by name
                "task",  // 2 such items
                "3",    // delete
                "1",    // item's serial number
                "1",    // Show all items
                "6"     // Exit
        };
        new StartUI(new StubInput(answers), tracker).init();


        assertThat(tracker.getAll()[0].getName(), is(testName0)); // проверяем, что элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.getAll()[1].getName(), is(testName2));
        assertThat(tracker.getAll()[2].getName(), is(testName3));



    } // StubInputTest


}
