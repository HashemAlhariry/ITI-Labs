package gov.iti.jets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {


    @GetMapping("/register")
    public String createNewUser(Model model){
        model.addAttribute(new User("New User","10000",20));
        return "formView";
    }

    @PostMapping(value = "/register")
    public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult result){
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()){
            modelAndView.setViewName("formView");
            return modelAndView;
        }
        else{
            System.out.println(user.getName());
            modelAndView.addObject("msg", "hello"+user.getName());
            modelAndView.setViewName("hello");
            return modelAndView;
        }
    }
}
