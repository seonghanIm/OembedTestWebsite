package com.test.oembed.domain.dto;

import com.test.oembed.domain.OembedEntity;

public class OembedResponseDto {
    private String title;
    private String author_name;
    private String author_url;
    private String type;
    private int height;
    private int width;
    private String version;
    private String provider_name;
    private String provider_url;
    private int thumbnail_height;
    private int thumbnail_width;
    private String thumbnail_url;
    private String html;
    private String url;
    private String cache_age;

    public OembedResponseDto(OembedEntity entity) {
        this.title = entity.getTitle();
        this.author_name = entity.getAuthor_name();
        this.author_url = entity.getAuthor_url();
        this.type = entity.getType();
        this.height = entity.getHeight();
        this.width = entity.getWidth();
        this.version = entity.getVersion();
        this.provider_name = entity.getProvider_name();
        this.provider_url = entity.getProvider_url();
        this.thumbnail_height = entity.getThumbnail_height();
        this.thumbnail_width = entity.getThumbnail_width();
        this.thumbnail_url = entity.getThumbnail_url();
        this.html = entity.getHtml();
        this.url = entity.getUrl();
        this.cache_age = entity.getCache_age();
    }

}
