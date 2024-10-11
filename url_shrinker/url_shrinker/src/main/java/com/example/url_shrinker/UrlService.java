package com.example.url_shrinker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {
    @Autowired
    private UrlRepository repository;


    public Optional<UrlEntity> getLongUrl(String shortUrl) {
        return repository.findByShortUrl(shortUrl);
    }


}
