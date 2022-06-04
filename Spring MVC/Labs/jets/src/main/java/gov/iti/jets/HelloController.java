package gov.iti.jets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/hello")
public class HelloController  {

    @RequestMapping(method = RequestMethod.GET)
    public String getMessage(Model model){
        model.addAttribute("msg", "hello from annotated controller");
        return "hello";
    }

}
