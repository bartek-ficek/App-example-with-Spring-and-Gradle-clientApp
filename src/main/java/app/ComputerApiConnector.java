package app;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/deleteDataFromComputerApi")
    public void deleteDataFromComputerApi(@RequestParam long id){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(
                "http://localhost:8081/Gradle___pl_bartek_ficek___electronic_apps_1_0_SNAPSHOT_war__exploded_/api/computers"+"?id="+id,
                HttpMethod.DELETE,
                null,
                Boolean.class);
        System.out.println(responseEntity.getBody());
    }

    @GetMapping("/sendDataToComputerApi")
    public void sendDataToComputerApi(){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(httpHeaders.CONTENT_TYPE,"application/json");
        String objToSend = "{\n" +
                "        \"id\": 5,\n" +
                "        \"ddrType\": \"DDR5\",\n" +
                "        \"memorySize\": 50,\n" +
                "        \"mhz\": 5000\n" +
                "    }";

        HttpEntity<String> httpEntity = new HttpEntity<>(objToSend, httpHeaders);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(
                "http://localhost:8081/Gradle___pl_bartek_ficek___electronic_apps_1_0_SNAPSHOT_war__exploded_/api/computers",
                HttpMethod.POST,
                httpEntity,
                Void.class);
        System.out.println(responseEntity.getBody());
    }
}