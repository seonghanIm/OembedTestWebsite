package com.test.oembed.service;

import com.test.oembed.domain.dto.OembedResponseDto;

public interface OembedService {
    public static String checkDomain(String url) {
        String domain = "";

        if (url.contains("youtube.com")) {
            domain = "youtube";
        } else if (url.contains("twitter.com")) {
            domain = "twitter";
        } else if (url.contains("vimeo.com")) {
            domain = "vimeo";
        }

        return domain;
    }

    ;

    public OembedResponseDto checkOembedType(String url);

    public OembedResponseDto getOembed(String url, String api);

}
