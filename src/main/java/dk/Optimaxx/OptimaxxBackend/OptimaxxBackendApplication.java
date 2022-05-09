package dk.Optimaxx.OptimaxxBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class OptimaxxBackendApplication {

    @GetMapping
    public static String index() {
        return "redirect:/swagger-ui/index.html";
    }

    public static void main(String[] args) {
        SpringApplication.run(OptimaxxBackendApplication.class, args);
    }

}
