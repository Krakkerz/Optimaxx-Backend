package dk.Optimaxx.OptimaxxBackend.utilities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DurationFormatterTest {

    @Test
    void formatDuration() {
        assertEquals(DurationFormatter.formatDuration(Duration.ZERO), "0h 0m");
        assertEquals(DurationFormatter.formatDuration(Duration.ZERO.plusMinutes(10)), "0h 10m");
        assertEquals(DurationFormatter.formatDuration(Duration.ZERO.plusMinutes(70)), "1h 10m");
        assertEquals(DurationFormatter.formatDuration(Duration.ZERO.plusHours(25)), "25h 0m");
        assertEquals(DurationFormatter.formatDuration(Duration.ZERO.plusMinutes(255)), "4h 15m");
        assertEquals(DurationFormatter.formatDuration(Duration.ZERO.minusMinutes(34)), "0h -34m");
    }

    @Test
    void formatLocalDateTime() {
    }

    @Test
    void formatForDate() {
    }
}
