package com.ex.search.Repository;

import com.ex.search.domain.SearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SearchRepository extends JpaRepository<SearchEntity, Integer> {
    List<SearchEntity> findByNameContaining(String keyword);
}

