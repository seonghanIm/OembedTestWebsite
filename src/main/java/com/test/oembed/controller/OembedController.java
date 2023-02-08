package com.test.oembed.controller;


import com.test.oembed.service.OembedServicempl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class OembedController {

    private final OembedServicempl oembedServicempl;
    private final Logger logger = LoggerFactory.getLogger(OembedController.class);

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> controllerExceptionHandler(Exception e) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        logger.info(e.getMessage());
        logger.info("IllegalArgumentException in OembedController");
        Map<String, String> model = new HashMap<>();
        model.put("error type", httpStatus.getReasonPhrase());
        model.put("code", "404");
        model.put("message", "URL이 정확하지 않습니다.");
        return new ResponseEntity<>(model, httpHeaders, httpStatus);
    }

    @GetMapping("/search")
    public String search(@RequestParam("url") String url, Model model) {
        if (url.isEmpty()) {
            throw new IllegalArgumentException("Url is null");
        }
        model.addAttribute("oembedData", oembedServicempl.checkOembedType(url));
        return "index";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


}
