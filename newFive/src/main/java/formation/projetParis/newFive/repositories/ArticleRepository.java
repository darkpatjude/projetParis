package formation.projetParis.newFive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.projetParis.newFive.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {


}
