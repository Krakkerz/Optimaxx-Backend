package dk.Optimaxx.OptimaxxBackend;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("production")
public class FudgeTests {

    @Test
    void doNothing() {
        assertTrue(true);
    }
}
