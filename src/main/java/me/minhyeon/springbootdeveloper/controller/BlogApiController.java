package me.minhyeon.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.minhyeon.springbootdeveloper.domain.Article;
import me.minhyeon.springbootdeveloper.dto.AddArticleRequest;
import me.minhyeon.springbootdeveloper.dto.ArticleRespnse;
import me.minhyeon.springbootdeveloper.dto.UpdateArticleRequest;
import me.minhyeon.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleRespnse>> findAllArticles(){
        List<ArticleRespnse> articles = blogService.findAll()
                .stream()
                .map(ArticleRespnse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleRespnse> findArticle (@PathVariable long id){
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleRespnse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        blogService.deletete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
                                                 @RequestBody UpdateArticleRequest request){
        Article updateArticle = blogService.update(id,request);

        return ResponseEntity.ok()
                .body(updateArticle);
    }
}
