package crud.Controller;


import crud.Model.User;
import crud.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping()
    public String allUsers(ModelMap model){
        List<User> userList = userService.getUsers();
        model.addAttribute("allUsers", userList);
        return "users/users";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("updatedUser", userService.findUser(id));
        return "users/edit";
    }


    @PostMapping("/{id}")
    public String patchUser(@ModelAttribute("updatedUser") User user){
        userService.editUser(user);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String newUser(@ModelAttribute("user") User user){
        return "users/add";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/users";
    }
}
