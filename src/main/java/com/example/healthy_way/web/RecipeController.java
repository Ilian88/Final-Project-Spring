package com.example.healthy_way.web;

import com.example.healthy_way.model.binding.RecipeBindingModel;
import com.example.healthy_way.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final String REDIRECT_RECIPE = "redirect:add";

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @ModelAttribute
    public RecipeBindingModel recipeBindingModel() {
        return new RecipeBindingModel();
    }

    @GetMapping("/all")
    public String getRecipes(Model model) {

        model.addAttribute("recipes",this.recipeService.getAll());

        return "recipes";
    }

    @GetMapping("/add")
    public String addRecipe() {

        return "add-recipe";
    }

    @GetMapping("/single-recipe/{id}")
    public String getRecipe(@PathVariable("id") String id,
                             Model model) {
        model.addAttribute("singleRecipe",this.recipeService.getById(id));

        return "single-recipe";
    }

    @GetMapping("/single-recipe/{id}/edit")
    public String editRecipe(@PathVariable("id") String id,
                             Model model) {
        model.addAttribute("singleRecipe",this.recipeService.getById(id));

        //TODO : fix the url in edit-recipe

        return "edit-recipe";

    }

    @PostMapping("/add")
    public String addConfirm(@ModelAttribute @Valid RecipeBindingModel recipeBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("recipeBindingModel",recipeBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.recipeBindingModel",
                      bindingResult);

            return REDIRECT_RECIPE;
        }

        this.recipeService.addRecipe(recipeBindingModel);

        return "redirect:/";

        // Todo: to add error messages

        // Todo : to disable like button;
    }

}
