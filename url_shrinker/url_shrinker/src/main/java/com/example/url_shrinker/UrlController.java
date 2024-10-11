package com.example.url_shrinker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UrlController {
    @Autowired
    private UrlService service;
    @Autowired
    private UrlRepository urlRepository;

    @PostMapping("/links")
    public UrlEntity createUrl(@RequestBody UrlEntity urlentity) {
        return urlRepository.save(urlentity);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Object> redirect(@PathVariable String shortUrl) {
        Optional<UrlEntity> urlMapping = service.getLongUrl(shortUrl);
        return urlMapping.map(mapping -> ResponseEntity.status(HttpStatus.FOUND).location(URI.create(mapping.getLongUrl())).build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
