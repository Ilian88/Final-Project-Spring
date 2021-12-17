package com.example.healthy_way.web;

import com.example.healthy_way.model.binding.ArticleBindingModel;
import com.example.healthy_way.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ModelAttribute
    public ArticleBindingModel addArticleBindingModel() {
        return new ArticleBindingModel();
    }

    @GetMapping("/all")
    public String getArticles(Model model){

        model.addAttribute("articles",this.articleService.getAllArticles());

        return "articles";
    }

    @GetMapping("/get/{id}")
    public String getSingleArticle(@PathVariable("id") String id , Model model) {

        model.addAttribute("_article",this.articleService.getArticleById(id));

        return "single-article";
    }

    @GetMapping("/add")
    public String addArticle() {

        return "add-article";
    }

    @GetMapping("/edit/{aId}")
    public String editArticle(@PathVariable("aId") String articleId,
                              ArticleBindingModel articleBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("articleBindingModel",articleBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                    bindingResult);

            return "redirect:edit/{aId}";
        }

        this.articleService.editArticle(articleId,articleBindingModel);

        return "redirect:/";
    }

    @PostMapping("/add")
    public String addArticleConfirm(@ModelAttribute @Valid ArticleBindingModel articleBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("articleBindingModel",articleBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                    bindingResult);

            return "redirect:add";
        }

        this.articleService.saveArticle(articleBindingModel);

        return "redirect:/";
    }



}
