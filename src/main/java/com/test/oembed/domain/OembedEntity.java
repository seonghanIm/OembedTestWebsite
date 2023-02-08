package com.test.oembed.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OembedEntity {
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
}
