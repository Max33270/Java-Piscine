import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", java.util.Locale.FRENCH);
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        stringDate = stringDate.replace("heures du soir", "PM");
        System.out.println(stringDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh' 'a', 'mm' minutes et 'ss' secondes'",
                java.util.Locale.FRENCH);
        LocalTime time = LocalTime.parse(stringDate, formatter);
        return time;
    }

}