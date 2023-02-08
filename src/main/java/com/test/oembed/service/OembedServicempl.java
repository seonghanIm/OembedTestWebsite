package com.test.oembed.service;


import com.test.oembed.domain.OembedEntity;
import com.test.oembed.domain.dto.OembedResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
@Component
public class OembedServicempl implements OembedService {
    @Value("${api.oembed.youtube}")
    private String YOUTUBE_API_URL;

    @Value("${api.oembed.twitter}")
    private String TWITTER_API_URL;

    @Value("${api.oembed.vimeo}")
    private String VIMEO_API_URL;


    public OembedResponseDto checkOembedType(String url) {
        OembedEntity oembedEntity = new OembedEntity();
        OembedResponseDto oembedResponseDto = new OembedResponseDto(oembedEntity);
        String domain = OembedService.checkDomain(url);

        if (domain.equals("youtube")) {
            oembedResponseDto = getOembed(url, YOUTUBE_API_URL);
        } else if (domain.equals("twitter")) {
            oembedResponseDto = getOembed(url, TWITTER_API_URL);
        } else if (domain.equals("vimeo")) {
            oembedResponseDto = getOembed(url, VIMEO_API_URL);
        }
        return oembedResponseDto;
    }

    public OembedResponseDto getOembed(String url, String api) {
        RestTemplate restTemplate = new RestTemplate();
        OembedEntity oembedEntity = restTemplate.getForObject(String.format(api, url), OembedEntity.class);
        OembedResponseDto oembedResponseDto = new OembedResponseDto(oembedEntity);
        return oembedResponseDto;
    }


}
