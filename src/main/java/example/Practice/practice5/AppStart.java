package example.Practice.practice5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class AppStart {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppStart.class);
        app.setAdditionalProfiles("practice5");
        app.run(args);
    }
}
