
package co.decem.mongo.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.decem.mongo.application.ArticleService;
import co.decem.mongo.domain.Article;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    public Article addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    @GetMapping("/all")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }
}
