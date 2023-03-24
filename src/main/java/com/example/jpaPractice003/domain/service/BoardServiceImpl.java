package com.example.jpaPractice003.domain.service;

import com.example.jpaPractice003.domain.dto.BoardDTO;
import com.example.jpaPractice003.domain.dto.PageListResultDTO;
import com.example.jpaPractice003.domain.dto.PageRequestDTO;
import com.example.jpaPractice003.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public PageListResultDTO<BoardDTO> getPageList(PageRequestDTO pageRequestDTO) {
        Page<BoardDTO> result = boardRepository.findByPageRequest(pageRequestDTO);
        PageListResultDTO<BoardDTO> boardDTOPageListResultDTO = new PageListResultDTO<>(result);
        return boardDTOPageListResultDTO;
    }
}
