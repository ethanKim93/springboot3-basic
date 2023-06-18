package me.minhyeon.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.minhyeon.springbootdeveloper.domain.Article;
import me.minhyeon.springbootdeveloper.dto.AddArticleRequest;
import me.minhyeon.springbootdeveloper.dto.UpdateArticleRequest;
import me.minhyeon.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found : "+ id));

    }

    public  void deletete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional// 트렌젝션 메서드
    public Article update(Long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not fount: " + id));

        article.update(request.getTitle(),request.getContent());

        return article;
    }
}
