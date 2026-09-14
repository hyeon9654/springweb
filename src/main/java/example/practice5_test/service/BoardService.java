package example.practice5_test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice5_test.model.dto.BoardDto;
import example.practice5_test.model.entity.BoardEntity;
import example.practice5_test.repository.BoardRepository;


@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // 1. 게시글 등록
    public boolean 게시물등록(BoardDto boardDto) {
        BoardEntity boardEntity = boardDto.toEntity();
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        return true;
    }

    // 2. 게시글 전체조회 + 댓글목록 포함
    public List<BoardDto> 게시물전체조회() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtos = new ArrayList<>();

        boardEntities.forEach(boardEntity -> {
            boardDtos.add(BoardDto.from(boardEntity));
        });

        return boardDtos;
    }

    // 3. 게시글 삭제 - 비밀번호 일치 시 삭제
    public boolean 게시물삭제(Integer id, String password) {
        Optional<BoardEntity> optional = boardRepository.findById(id);

        if (optional.isPresent()) {
            BoardEntity boardEntity = optional.get();
            if (boardEntity.getPassword().equals(password)) {
                boardRepository.delete(boardEntity);
                return true;
            }
        }
        return false;
    }
}
