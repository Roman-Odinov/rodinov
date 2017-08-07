package ru.job4j.Profession;

public class Profession {

    String name;
    String diploma;     // диплом
    String certificateList;    // сертификаты
    String patents;     // патенты
    String placeOfWork; // место работы
    boolean stateEmployee = true;   // гос. работник?
    double gross;      // оклад


    public String getName(){
        return this.name;
    }

    public double salaryCount(double gross) {
        return gross * 0.87;
    }

    /**
     * Work method.
     * What does exactly <person> do.
     */
    public void work() {
        /*
        печатает "это родительский класс"
         */
        System.out.print("это родительский класс");
    }



}
