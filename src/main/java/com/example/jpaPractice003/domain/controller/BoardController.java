package com.example.jpaPractice003.domain.controller;

import com.example.jpaPractice003.domain.dto.PageRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("board")
public class BoardController {

    @GetMapping
    public void testModelAttr(@ModelAttribute PageRequestDTO pageRequestDTO){
        log.info("pageRequestInfo = "+pageRequestDTO);
    }
}
