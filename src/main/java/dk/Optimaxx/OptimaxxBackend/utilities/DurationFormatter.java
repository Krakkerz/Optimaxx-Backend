package dk.Optimaxx.OptimaxxBackend.utilities;


import java.time.Duration;
import java.time.LocalDateTime;

public class DurationFormatter {
    public static String formatDuration(Duration duration) {
        return "%dh %dm".formatted(duration.toHours(), duration.toMinutesPart());
    }

    public static String formatLocalDateTime(LocalDateTime time) {
        return "%d:%d".formatted(time.getHour(), time.getMinute());
    }

    public static String formatForDate(LocalDateTime time) {
        return time.getDayOfWeek().toString().toLowerCase() + " " +  time.getMonth().toString().toLowerCase() + time.getYear();
    }
}
