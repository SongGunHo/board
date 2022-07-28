package com.its.board.service;

import com.its.board.dto.BoardDTO;
import com.its.board.entity.BoardEntity;
import com.its.board.reopsitory.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public Long save(BoardDTO boardDTO) {
      return   boardRepository.save(BoardEntity.toSaveEntity(boardDTO)).getId();
    }

    public BoardDTO findById(Long id) {
         Optional<BoardEntity> byId = boardRepository.findById(id);
         if(byId.isPresent()){
              BoardEntity boardEntity = byId.get();
           return    BoardDTO.toBoardDTO(boardEntity);
         }else {
             return null;
         }
    }
}
