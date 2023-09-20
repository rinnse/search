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

    public List<Search> searchByCategory(String category) {
        return searchRepository.findByCategoryContaining(category);
    }

    // searchByCategory 가 회색 처리 되어있다면 (오류) => Controller에 정의되어 있지 않다는 것.

    // SearchService.java
    public List<Search> getSuggestions(String keyword) {
        // DB에서 검색어에 맞는 식당 명(name) 검색
        List<Search> suggestions = searchRepository.findSuggestions("%" + keyword + "%");
        return suggestions;
    }

}

