package com.example.healthy_way.web;

import com.example.healthy_way.model.binding.AddRoleBindingModel;
import com.example.healthy_way.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public AddRoleBindingModel addRoleBindingModel() {
        return new AddRoleBindingModel();
    }

    @GetMapping("/add")
    public String addRole(Model model) {

        if (!model.containsAttribute("userNotSelected")) {
            model.addAttribute("userNotSelected",false);
        }
        model.addAttribute("usernames",this.userService.getAllUsernames());
        return "role-manage";
    }

    @PostMapping("/add")
    public String addRoleConfirm(@ModelAttribute AddRoleBindingModel addRoleBindingModel,
                                 RedirectAttributes redirectAttributes) {

        if (!addRoleBindingModel.getUsername().equals("")) {
            this.userService.changeRoleOfUser(addRoleBindingModel);
            return "redirect:/";
        }

        redirectAttributes.addFlashAttribute("userNotSelected",true);
        return "redirect:add";
    }
}
