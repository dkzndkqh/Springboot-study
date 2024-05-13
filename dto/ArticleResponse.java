package org.example.springdeveloper.dto;

import lombok.Getter;
import org.example.springdeveloper.domain.Article;

@Getter
public class ArticleResponse {
    private String title;
    private String content;

    public ArticleResponse(Article article) {

        this.title = article.getTitle();
        this.content = article.getContent();

    }

}
