package ru.job4j.Profession;

import org.junit.Test;

public class DoctorTest {

    @Test
    public void workTest() {
        Doctor doctor = new Doctor();
        doctor.diploma = "Первый мед, 1999г.";
        doctor.certificateList = "Кучу супер-пупер сертификатов";
        doctor.placeOfWork = "Управление делами президента";
        doctor.gross = 36000;
        doctor.name = "Иван";
        doctor.patientName = "Сергей";
        doctor.work();

    }

}