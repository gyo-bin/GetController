package kr.hs.dgsw.web_get;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetController {

    @GetMapping(value = "/greeting") //웹 주소에 /greeting을 넣어야만 이함수를 사용할수있음
    public String sayHello(
            @RequestParam(required = false, defaultValue = "Hello")String say,
            @RequestParam(required = false, defaultValue = "NONAME")String to){  //값이 없으면 NONAME
        return say + " " + to;
    }

    @GetMapping(
            value = {"/greeting1/{say}/{to}",
                    "/greeting1/{say}",
                    "/greeting1",
            })
    public String sayHello1(
            @PathVariable Optional<String> say,
            @PathVariable Optional<String> to
    ){
        //tmp가 to값이 되던가 없으면 noname
        String tmp = to.isPresent() ? to.get() : "NONAME";
        return say.isPresent() ? say.get() : "hello" + " " + tmp;
    }
}
