package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.service.RoleService;
import apap.tutorial.emsidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping(value = "/viewall")
    public String listUser(Model model) {
        List<UserModel> listUser = userService.getUserList();

        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping(value = "/delete/{username}")
    public String deleteUserSubmit(
            @PathVariable String username,
            Model model
    ) {
        UserModel user = userService.getUserbyUsername(username);
        userService.deleteUser(user);
        return "home";
    }

    @GetMapping(value = "/update/")
    public String updateUserForm(Model model) {
        return "form-update-user";
    }

}
