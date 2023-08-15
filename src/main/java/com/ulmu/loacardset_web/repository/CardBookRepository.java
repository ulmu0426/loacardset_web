package com.ulmu.loacardset_web.repository;

import com.ulmu.loacardset_web.model.CardBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardBookRepository extends JpaRepository<CardBook, Long> {
    //카드도감 정렬
    List<CardBook> findAllOrderByCardBookIdDesc(String keyword);
    List<CardBook> findAllOrderByNameDesc(String keyword);

    //특정 스탯 도감 정렬
    List<CardBook> findByStatNameContainingOrderByCardBookIdDesc(String statName);      //파라미터로 받은 스탯을 가진 도감 id 순으로 정렬
    List<CardBook> findByStatNameContainingOrderByCardBookNameDesc(String statName);    //파라미터로 받은 스탯을 가진 도감 이름 순으로 정렬
}
