package me.minhyeon.springbootdeveloper.dto;

import lombok.Getter;
import me.minhyeon.springbootdeveloper.domain.Article;

@Getter
public class ArticleRespnse {
    private final String title;
    private final String content;

    public ArticleRespnse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
