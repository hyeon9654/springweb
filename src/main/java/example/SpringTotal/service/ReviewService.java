package example.SpringTotal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.SpringTotal.model.dto.ReviewDto;
import example.SpringTotal.model.entity.ReviewEntity;
import example.SpringTotal.repository.CategoryRepository;
import example.SpringTotal.repository.ProductRepository;
import example.SpringTotal.repository.ReviewRepository;
import jakarta.transaction.Transactional;

@Transactional 
@Service 
public class ReviewService {
    @Autowired CategoryRepository categoryRepository;
    @Autowired ProductRepository productRepository;
    @Autowired ReviewRepository reviewRepository;

    // 1. 제품별 리뷰 조회 기능 ( GET,List<ReviewDto> )
    public List<ReviewDto> 제품별조회( ){
        List<ReviewEntity> reviewEntities = reviewRepository.findAll();
        List<ReviewDto> reviewDtos = new ArrayList<>();
        reviewEntities.forEach(reviewEntity -> {
            ReviewDto reviewDto = ReviewDto.entityToDto(reviewEntity);
            reviewDtos.add(reviewDto);
        }); return reviewDtos;
    }

    // 2. 제품 리뷰 등록 기능 ( POST, boolean )
    public boolean 제품리뷰등록(example.SpringTotal.model.dto.ReviewDto reviewDto){
        ReviewEntity reviewEntity = reviewDto.dtoToEntity();
        ReviewEntity savedEntity = reviewRepository.save(reviewEntity);
        if ( savedEntity.getRno() >= 1 ) return true;
            return false;
    }
    // 3. 제품 리뷰 삭제 기능 ( DELETE, boolean )
    public boolean 리뷰삭제( Integer rno ){
        Optional<ReviewEntity> optional = reviewRepository.findById(rno);

        if (optional.isPresent()) {
            reviewRepository.deleteById(rno);
            return true;
        } return false;
    } 
}