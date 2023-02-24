import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        String num = dateTime.format(java.time.format.DateTimeFormatter.ofPattern("d", java.util.Locale.FRENCH));
        String month = dateTime.format(java.time.format.DateTimeFormatter.ofPattern("MMM", java.util.Locale.FRENCH));
        String year = dateTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyy", java.util.Locale.FRENCH));
        String hour = dateTime.format(java.time.format.DateTimeFormatter.ofPattern("HH", java.util.Locale.FRENCH));
        String min = dateTime.format(java.time.format.DateTimeFormatter.ofPattern("mm", java.util.Locale.FRENCH));
        String sec = dateTime.format(java.time.format.DateTimeFormatter.ofPattern("ss", java.util.Locale.FRENCH));
        return "Le " + num + " " + month + " de l'an " + year + " à " + hour + "h" + min + "m " + "et " +  sec + "s";  
    }


    public static String formatSimple(LocalDate date) {
        if (date == null) {
            return null;
        }
        String num = date.format(java.time.format.DateTimeFormatter.ofPattern("d", java.util.Locale.ITALIAN));
        String month = date.format(java.time.format.DateTimeFormatter.ofPattern("MMMM", java.util.Locale.ITALIAN));
        String year = date.format(java.time.format.DateTimeFormatter.ofPattern("yy", java.util.Locale.ITALIAN));
        return month + " " + num + " " + year;
    }

    public static String formatIso(LocalTime time) {
        if (time == null) {
            return null;
        }
        String hour = time.format(java.time.format.DateTimeFormatter.ofPattern("HH", java.util.Locale.FRENCH));
        String min = time.format(java.time.format.DateTimeFormatter.ofPattern("mm", java.util.Locale.FRENCH));
        String sec = time.format(java.time.format.DateTimeFormatter.ofPattern("ss", java.util.Locale.FRENCH));
        String nano = time.format(java.time.format.DateTimeFormatter.ofPattern("n", java.util.Locale.FRENCH));
        if (time.getNano() == 0) {
            return hour + ":" + min + ":" + sec; 
        } else {
            return hour + ":" + min + ":" + sec + "." + nano; 
        }
    }
}
