package com.example.jpaPractice003.domain.repository;

import com.example.jpaPractice003.domain.dto.BoardDTO;
import org.springframework.data.domain.Page;

public interface BoardCustomRepository {
    public Page<BoardDTO> findByPageRequest();
}
