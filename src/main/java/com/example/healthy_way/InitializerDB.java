package com.example.healthy_way;

import com.example.healthy_way.model.entity.Article;
import com.example.healthy_way.model.entity.Recipe;
import com.example.healthy_way.model.entity.UserEntity;
import com.example.healthy_way.model.enums.GenderEnum;
import com.example.healthy_way.model.enums.RoleEnum;
import com.example.healthy_way.repository.ArticleRepository;
import com.example.healthy_way.repository.RecipeRepository;
import com.example.healthy_way.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitializerDB implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ArticleRepository articleRepository;
    private final RecipeRepository repository;

    public InitializerDB(UserRepository userRepository, PasswordEncoder passwordEncoder,
                         ArticleRepository articleRepository, RecipeRepository repository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.articleRepository = articleRepository;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity user1 = new UserEntity();

        if (userRepository.count() == 0) {

            user1.setUsername("Iliyan")
                    .setPassword(passwordEncoder.encode("12345"))
                    .setGenderEnum(GenderEnum.MALE)
                    .setAge(33)
                    .setRole(RoleEnum.ADMIN)
                    .setEmail("iliyan.markov@abv.bg");

            this.userRepository.save(user1);
        }

        if (articleRepository.count() == 0) {
            Article article = new Article()
                    .setAuthor(user1)
                    .setTitle("First Article")
                    .setShortDescription("Some short Lorem Ipsum")
                    .setTextContent("Some long Lorem Ipsum")
                    .setCreatedOn(LocalDateTime.now());

            this.articleRepository.save(article);
        }

        if (repository.count() == 0) {
            Recipe recipe = new Recipe()
                    .setAuthor(user1)
                    .setName("Some fish")
                    .setCreatedOn(LocalDateTime.now())
                    .setShorDescription("Lorem ipsum short fgj gj gh jgh jg jg")
                    .setTextContent("Lorem ipsum long f fh fhfhfhfhf hffhfghf")
                    .setImageURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1_Y9N1HSORDn0kxmeAZdebNGGYFWOQG58JA&usqp=CAU");

            this.repository.save(recipe);
        }

    }

}
