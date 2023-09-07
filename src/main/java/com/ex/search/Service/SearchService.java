package com.ex.search.Service;

import com.ex.search.Repository.SearchRepository;
import com.ex.search.domain.SearchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private SearchRepository searchRepository;

    public List<SearchEntity> searchKeywords(String keyword) {
        return searchRepository.findByNameContaining(keyword);
    }
}

