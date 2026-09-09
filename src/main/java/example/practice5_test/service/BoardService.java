package example.practice5_test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.day02.model.dto.BoardDto;
import example.day06.BoardEntity;
import example.practice5.model.repository.BoardRepository;

@Service 
public class BoardService {
    @Autowired private BoardRepository boardRepository;

    // 1.
    public boolean 게시글등록( BoardDto boardDto ){
        BoardEntity boardEntity = boardDto.toEntity();
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        if (savedEntity.getId() >= 1) {return true;}
     return false;
}
    // 2.
    public List<BoardDto> 게시글전체조회(){

        List<BoardEntity> BoardEntities = boardRepository.findAll();
        List<BoardDto> boardDtos = new ArrayList<>();
        boardEntities.forEach((boardEntity) -> {
            BoardDto boardDto = BoardDto.from(boardEntity);
            boardDto.getComments().add;
        });
        return boardDtos;             
    }
}
    

