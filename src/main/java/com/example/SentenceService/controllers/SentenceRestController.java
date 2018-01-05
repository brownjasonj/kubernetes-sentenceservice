package com.example.SentenceService.controllers;

import com.example.SentenceService.services.NounServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentenceRestController {

    @Autowired
    NounServiceDelegate nounServiceDelegate;

    @RequestMapping("/noun")
    public @ResponseBody
    String getNoun() {
        return nounServiceDelegate.callNounService();
    }
}
