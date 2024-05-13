package org.example.springdeveloper.repository;

import org.example.springdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;


// JpaRepository를 상속받을 때 Entity인 Article과 PK(기본키)인 id의 타입 Long값을 준다.
public interface BlogRepository extends JpaRepository<Article, Long> {
}
