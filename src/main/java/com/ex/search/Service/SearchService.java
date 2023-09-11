package com.ex.search.Service;

import com.ex.search.Repository.SearchRepository;
import com.ex.search.domain.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private SearchRepository searchRepository;

    public List<Search> searchRestaurants(String name) {
        return searchRepository.findByNameContaining(name);
    }

    // SearchService.java
    public List<Search> getSuggestions(String keyword) {
        // DB에서 검색어에 맞는 식당 명(name) 검색
        List<Search> suggestions = searchRepository.findSuggestions("%" + keyword + "%");
        return suggestions;
    }

}

