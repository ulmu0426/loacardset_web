package com.ulmu.loacardset_web.repository;

import com.ulmu.loacardset_web.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    //기본 정렬
    List<Card> findAllOrderByCardIdDesc(String keyword);      //모든 카드 기본 순 정렬
    List<Card> findAllOrderByNameDesc(String keyword);        //모든 카드 이름 순 정렬
    List<Card> findAllOrderByGetCardDesc(String keyword);     //모든 카드 획득카드 우선 정렬

    //등급별 정렬
    List<Card> findAllByGradeOrderByCardIdDesc(String grade);   //파라메터로 받은 등급 기본순 정렬
    List<Card> findAllByGradeOrderByNameDesc(String grade);     //파라메터로 받은 등급  이름순 정렬
    List<Card> findAllByGradeOrderByGetCardDesc(String grade);  //파라메터로 받은 등급  획득카드 우선 정렬 내림차순

    //각성도순 정렬
    List<Card> findAllOrderByAwakeAsc(String keyword);   //모든 카드 각성도순 정렬
    List<Card> findAllByGradeOrderByAwakeAsc(String grade);   //해당 등급 카드 각성도순 정렬
}
