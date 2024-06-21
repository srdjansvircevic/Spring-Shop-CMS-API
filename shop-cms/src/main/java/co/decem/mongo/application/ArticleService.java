
package co.decem.mongo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.decem.mongo.domain.Article;
import co.decem.mongo.domain.repository.ArticleRepository;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
