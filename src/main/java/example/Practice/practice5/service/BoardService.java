package example.Practice.practice5.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice.practice5.model.dto.BoardDto;
import example.Practice.practice5.model.dto.CommentDto;
import example.Practice.practice5.model.entity.BoardEntity;
import example.Practice.practice5.model.repository.BoardRepository;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    // 1. 게시글 등록
    public boolean 게시물등록(BoardDto boardDto){
        BoardEntity boardEntity = boardDto.toEntity();
        BoardEntity savedEntity =
                boardRepository.save(boardEntity);
        if (savedEntity.getId() >= 1) return true;
        return false;
    }

    // 2. 게시글 전체조회
    public List<BoardDto> 게시물전체조회( ){
        // 모든 entity -> dto변환, 여러번(반복)
        List<BoardEntity> boardEntities =
                boardRepository.findAll();
        List<BoardDto> boardDtos =
                new ArrayList<>();
        boardEntities.forEach(boardEntity -> {
            // 게시글 Entity -> DTO
            BoardDto boardDto =
                    BoardDto.from(boardEntity);
            // 해당 게시글의 댓글들을 반복
            boardEntity.getComments().forEach(commentEntity -> {
                // 댓글 Entity -> DTO
                CommentDto commentDto =
                        CommentDto.from(commentEntity);
                // 게시글 DTO의 댓글 목록에 추가
                boardDto.getComments().add(commentDto);
            });
            boardDtos.add(boardDto);
        });
        return boardDtos;
    }

    // 3. 게시글 삭제
    public boolean 게시물삭제(
            Integer id,
            String password) {
        Optional<BoardEntity> optional =
                boardRepository.findById(id);
        if (optional.isPresent()) {
            BoardEntity boardEntity =
                    optional.get();
            if (boardEntity
                    .getPassword()
                    .equals(password)) {
                boardRepository.delete(boardEntity);
                return true;
            }
        }
        return false;
    }
}