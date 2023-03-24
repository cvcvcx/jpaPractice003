package com.example.jpaPractice003.domain.repository;

import com.example.jpaPractice003.domain.dto.BoardDTO;
import com.example.jpaPractice003.domain.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface BoardCustomRepository {
    public Page<BoardDTO> findByPageRequest(PageRequestDTO pageRequestDTO);
}
