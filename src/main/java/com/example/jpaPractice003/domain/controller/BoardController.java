package com.example.jpaPractice003.domain.controller;

import com.example.jpaPractice003.domain.dto.BoardDTO;
import com.example.jpaPractice003.domain.dto.PageListResultDTO;
import com.example.jpaPractice003.domain.dto.PageRequestDTO;
import com.example.jpaPractice003.domain.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("board")
public class BoardController {

    private final BoardService boardService;
    @GetMapping
    public PageListResultDTO<BoardDTO> showBoardList(@ModelAttribute PageRequestDTO pageRequestDTO){
        log.info("pageRequestInfo = "+pageRequestDTO);
        PageListResultDTO<BoardDTO> pageList = boardService.getPageList(pageRequestDTO);
        return pageList;
    }
}
