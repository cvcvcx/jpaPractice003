package com.example.jpaPractice003.domain.service;

import com.example.jpaPractice003.domain.dto.BoardDTO;
import com.example.jpaPractice003.domain.dto.PageListResultDTO;
import com.example.jpaPractice003.domain.dto.PageRequestDTO;

public interface BoardService {

    public PageListResultDTO<BoardDTO> getPageList(PageRequestDTO pageRequestDTO);
    
}
