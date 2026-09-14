package example.practice5.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice5.model.dto.BoardDto;
import example.practice5.model.entity.BoardEntity;
import example.practice5.model.repository.BoardRepository;

@Service 
public class BoardService {
    @Autowired private BoardRepository boardRepository;

    // 1. 
    public boolean 게시물등록(example.practice5_test.model.dto.BoardDto boardDto){
        BoardEntity boardEntity = boardDto.toEntity();
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        if (savedEntity.getId() >= 1) return true;
        return false;
    }
    // 2.
    public List<BoardDto> 게시물전체조회( ){
        List<BoardEntity> boardEntities = boardRepository.findAll(); // 모든 entity -> dto변환, 여러번(반복)
        List<BoardDto> boardDtos = new ArrayList<>();
        boardEntities.forEach(boardEntity -> {
            BoardDto boardDto = BoardDto.from(boardEntity);
            boardDtos.add(boardDto);
        }); return boardDtos;
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
}
