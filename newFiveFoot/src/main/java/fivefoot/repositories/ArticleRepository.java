package fivefoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fivefoot.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}