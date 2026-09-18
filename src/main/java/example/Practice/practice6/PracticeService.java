package example.Practice.practice6;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service 
public class PracticeService {
    @Value ("${api.public-data.service-key}")
    private String serviceKey;
    
    private WebClient webClient = WebClient.builder().build();

    public Map<String,Object> getRestaurants() {
        String url = "";
        url += "?serviceKey=" + serviceKey;
        url += "&pageNo=" + 1;
        url += "&numOfRows=" + 10;
        url += "&returnType=json";

        Map<String,Object> response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        return response;
    }
}
