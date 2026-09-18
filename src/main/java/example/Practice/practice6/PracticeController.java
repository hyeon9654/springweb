package example.Practice.practice6;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
public class PracticeController {
    private final PracticeService practiceService;

    @GetMapping("/practice6/restaurants")
    public Map<String,Object> getRestaurants() {
        return practiceService.getRestaurants();
    }
}
