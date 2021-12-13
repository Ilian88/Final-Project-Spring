package com.example.healthy_way.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RecipeBindingModel {

    private String name;

    private String imageURL;

    private String textContent;

    private String shorDescription;

    public RecipeBindingModel() {
    }

    @NotNull
    @Size(min = 3,max = 25,message = "Name must be between 3 and 25 characters")
    public String getName() {
        return name;
    }

    public RecipeBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull(message = "Image URL is required")
    public String getImageURL() {
        return imageURL;
    }

    public RecipeBindingModel setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    @NotNull(message = "Text content cannot be null")
    @Size(min = 20,max = 1500,message = "Content must be between 20 and 1500 characters")
    public String getTextContent() {
        return textContent;
    }

    public RecipeBindingModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @Size(min = 5,max = 50,message = "Short description between 5 and 50 characters")
    public String getShorDescription() {
        return shorDescription;
    }

    public RecipeBindingModel setShorDescription(String shorDescription) {
        this.shorDescription = shorDescription;
        return this;
    }
}
