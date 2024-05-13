package org.example.springdeveloper.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springdeveloper.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter


public class AddArticleRequest {  // 블로그에 글을 추가할 때 저장할 엔티티로 변환하는 용도
    private String title;

    private String content;

    public Article toEntity(String author) {
        return Article.builder().title(title).content(content).author(author).build();
    }
}
