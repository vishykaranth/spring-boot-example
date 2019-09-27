package hello;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import controller.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Hello greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Hello(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", defaultValue="Ram") String name) {
        return String.format(template, name);
    }

    @RequestMapping("/company")
    public List<Company> company(@RequestParam(value="name", defaultValue="None") String name) {
        SelectRows selectRows = new SelectRows();
        return selectRows.getCompanyList();
    }
}
