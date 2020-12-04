package app;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@RestController
public class ComputerApiConnector {

    @GetMapping("/getDataFromComputerApi")
    public void getDataFromComputerApi(){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Computer[]> responseEntity = restTemplate.exchange(
                "http://localhost:8081/Gradle___pl_bartek_ficek___electronic_apps_1_0_SNAPSHOT_war__exploded_/api/computers",
                HttpMethod.GET,
                null,
                Computer[].class);

        Stream.of(responseEntity.getBody()).forEach(System.out::println);
    }
}

