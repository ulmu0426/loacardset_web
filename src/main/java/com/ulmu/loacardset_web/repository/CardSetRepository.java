package com.ulmu.loacardset_web.repository;

import com.ulmu.loacardset_web.model.CardSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardSetRepository extends JpaRepository<CardSet, Long> {
    //카드세트 정렬
    List<CardSet> findAllOrderByCardIdDesc(String keyword);     //id순 정렬 내림차순
    List<CardSet> findAllOrderByNameDesc(String keyword);       //이름순 정렬 내림차순
    List<CardSet> findAllOrderByFavoriteAsc(String keyword);       //즐겨찾기순 정렬 내림차순

    //카드 세트 검색 결과 정렬
    List<CardSet> findByNameContainingOrderByNameDesc(String name); //이름순 정렬 내림차순
    List<CardSet> findByNameContainingOrderByNameAsc(String name); //이름순 정렬 오름차순

}
