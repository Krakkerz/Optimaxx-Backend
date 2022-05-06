package dk.Optimaxx.OptimaxxBackend.utilities;


import java.time.Duration;

public class DurationFormatter {
    public static String format(Duration duration) {
        return "%dh %dm".formatted(duration.toHours(), duration.toMinutesPart());
    }
}
