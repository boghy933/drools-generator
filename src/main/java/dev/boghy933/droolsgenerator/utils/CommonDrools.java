package dev.boghy933.droolsgenerator.utils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;


public class CommonDrools {

    public static boolean ageBetween(Date birthDate, Integer start, Integer end) {
        LocalDate birthDateLocalDate = Instant.ofEpochMilli(birthDate.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate now = LocalDate.now();

        if (birthDate == null || now == null) {
            return false;
        }

        Integer years = Period.between(birthDateLocalDate, now).getYears();

        System.out.println("year: " + birthDateLocalDate.getYear());
        System.out.println("month: " + birthDateLocalDate.getMonth().getValue());
        System.out.println("day: " + birthDateLocalDate.getDayOfMonth());

        System.out.println("now year: " + LocalDate.now().getYear());
        System.out.println("now month: " + LocalDate.now().getMonth().getValue());
        System.out.println("now day: " + LocalDate.now().getDayOfMonth());

        System.out.println("Years: " + years);
        System.out.println("start: " + start);
        System.out.println("end: " + end);

        if (years >= start && years <= end) {
            System.out.println("Age is ok");
            return true;
        }

        return false;
    }
}
