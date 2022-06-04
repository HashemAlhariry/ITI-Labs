package gov.iti.jets;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestingRest {
    List<String> list = new ArrayList<>();

    @GetMapping("/getString")
    public List<String> getStringList(){
        for (int i = 0; i <1000000 ; i++) {
            list.add("Hello");
        }
        return list;
    }
}
