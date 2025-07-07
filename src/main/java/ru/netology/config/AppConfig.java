package ru.netology.config;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.repository.PostRepository;
import ru.netology.service.PostService;
import ru.netology.controller.PostController;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.netology")
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public PostRepository postRepository() {
        return new PostRepository();
    }

    @Bean
    public PostService postService(PostRepository repository) {
        return new PostService(repository);
    }

    @Bean
    public PostController postController(PostService service) {
        return new PostController(service);
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson());
        converters.add(converter);
    }
}