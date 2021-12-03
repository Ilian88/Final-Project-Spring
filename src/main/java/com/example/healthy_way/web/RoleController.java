package com.example.healthy_way.web;

import com.example.healthy_way.model.binding.AddRoleBindingModel;
import com.example.healthy_way.service.RoleService;
import com.example.healthy_way.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;
    private final UserService userService;

    public RoleController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @ModelAttribute
    public AddRoleBindingModel addRoleBindingModel() {
        return new AddRoleBindingModel();
    }

    @GetMapping("/add")
    public String addRole(Model model) {

        model.addAttribute("usernames",this.userService.getAllUsernames());

        return "role-manage";
    }

    @PostMapping("/add")
    public String addRoleConfirm(@ModelAttribute AddRoleBindingModel addRoleBindingModel) {

        this.userService.changeRoleOfUser(addRoleBindingModel);

        return null;
    }
}
