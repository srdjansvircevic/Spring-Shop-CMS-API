
package co.decem.mongo.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.decem.mongo.domain.Article;

public interface ArticleRepository extends MongoRepository<Article, String> {
}
