package dk.Optimaxx.OptimaxxBackend.utilities;


import java.time.Duration;
import java.time.LocalDateTime;

public class DurationFormatter {
    public static String formatDuration(Duration duration) {
        return "%dh %dm".formatted(duration.toHours(), duration.toMinutesPart());
    }
}
