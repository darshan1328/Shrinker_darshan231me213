package com.example.url_shrinker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Random;


@Entity
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String longUrl;
    private String shortUrl;

    public UrlEntity(){

    }

    public UrlEntity(String Long_url, String Custom_url) {
        super();
        this.longUrl = Long_url;
        this.shortUrl= Custom_url;

    }
    public String getLongUrl() {
        return longUrl;
    }
    public void setLong_url(String Long_url) {
        this.longUrl = Long_url;
    }
    public String getShort_url() {
        return shortUrl;
    }

    public void setShort_url( String Custom_url) {
        if(Custom_url!=null) {
            this.shortUrl = Custom_url;
        }
        else{
            String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder shortURL = new StringBuilder(8);
            Random random = new Random();

            for (int i = 0; i < 6; i++) {
                shortURL.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
            }
            shortUrl = shortURL.toString();
        }

    }
}

