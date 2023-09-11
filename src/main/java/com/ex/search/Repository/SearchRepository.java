package com.ex.search.Repository;

import com.ex.search.domain.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface SearchRepository extends JpaRepository<Search, Integer> {
    List<Search> findByNameContaining(String keyword);

    // 검색 창에서 연관 단어 검색하기 위한 메서드
    @Query(value = "SELECT DISTINCT s.name FROM Search s WHERE s.name LIKE %:name%")
    List<Search> findSuggestions(@Param("name") String name);

}

