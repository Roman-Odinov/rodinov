package ru.job4j.Profession;

/**
 * Метод public Diagnose heal(Patient patient) {} из класса Doctor
 * возвращает строку "Доктор Иван лечит Сергея", где
 * Иван - это поле "name" доктора, а
 * Сергей - аргумент метода "patient".
 */
public class Doctor extends Profession {

    String patientName;     // имя пациента

    /**
     * печатает все что знает про доктора
     */
    public void work() {
    /*
    Используем заявленную getName()
    и вызовы методов diagnose и heal
     */
        System.out.print("Доктор " + this.getName());
        diagnose();
        heal(patientName);
        System.out.println("Хотя зарплата у него всего " + salaryCount(gross));
        if (this.stateEmployee)
            System.out.println("И он госслужащий");
        System.out.print("Работает в клинике '" + placeOfWork + "', закончил " + diploma + " и имеет " + certificateList);

    }

    public void diagnose() {
        System.out.print(" диагностирует");

    }


    public void heal(String patientName) {
        String patient = patientName;
        System.out.println(" и лечит пациентов типа " + patient + " уже очень-очень давно,");

    }

}
