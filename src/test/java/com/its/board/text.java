package com.its.board;

import static org.assertj.core.api.Assertions.*;
import com.its.board.dto.BoardDTO;
import com.its.board.reopsitory.BoardRepository;
import com.its.board.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;

@SpringBootTest
public class text {
    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;
    public BoardDTO newBoard(int i){
        BoardDTO board =
                new BoardDTO("testTitle"+i,"testWriter"+i,"testContents"+i);
        return board;
    }
    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("게시판테스트")
    public void boardSaveTest(){
         Long saveId = boardService.save(newBoard(1));
         BoardDTO byId = boardService.findById(saveId);
         assertThat(newBoard(1).getBoardWriter()).isEqualTo(byId.getBoardWriter());

    }
}
