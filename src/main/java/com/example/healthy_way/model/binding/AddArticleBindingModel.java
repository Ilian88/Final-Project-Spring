package com.example.healthy_way.model.binding;

import javax.validation.constraints.Size;

public class AddArticleBindingModel {

    private String id;

    private String title;

    private String textContent;

    private String shortDescription;

    public AddArticleBindingModel() {
    }

    @Size(min = 3,max= 20, message = "Title must be at least 3 characters!")
    public String getTitle() {
        return title;
    }

    public AddArticleBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    @Size(min = 30,message = "Content must be at least 20 characters!")
    public String getTextContent() {
        return textContent;
    }

    public AddArticleBindingModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @Size(min = 5,max = 30,message = "Short description must be between 5 and 30 characters!")
    public String getShortDescription() {
        return shortDescription;
    }

    public AddArticleBindingModel setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }


    public String getId() {
        return id;
    }

    public AddArticleBindingModel setId(String id) {
        this.id = id;
        return this;
    }
}
