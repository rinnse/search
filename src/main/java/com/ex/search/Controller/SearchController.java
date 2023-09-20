package com.ex.search.Controller;

import com.ex.search.Service.SearchService;
import com.ex.search.domain.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;


    @RequestMapping("/search")
    public String search() {
        return "/search/search"; // search.html로 이동
    }

    @RequestMapping("/list")
    public String list(@RequestParam("name") String name, Model model) {
        List<Search> restaurantsByName = searchService.searchRestaurants(name);

        // 추가: 카테고리 검색 결과도 가져오기
        List<Search> restaurantsByCategory = searchService.searchByCategory(name); // 여기서 name은 카테고리명으로 사용

        // 검색 결과 합치기
        List<Search> combinedResults = new ArrayList<>();
        combinedResults.addAll(restaurantsByName);
        combinedResults.addAll(restaurantsByCategory);

        model.addAttribute("restaurants", combinedResults);
        return "/search/list"; // list.html로 이동
    }


    // 서버에서 검색어 처리 기능
    @RequestMapping("suggestions")
    @ResponseBody
    public List<Search> suggestions(@RequestParam("name") String name) {
        List<Search> suggestions = searchService.getSuggestions(name);
        return suggestions;
    }

    @RequestMapping("/category")
    public String searchByCategory(@RequestParam("category") String category, Model model) {
        List<Search> restaurantsByCategory = searchService.searchByCategory(category);
        model.addAttribute("restaurants", restaurantsByCategory);
        return "/search/list"; // list.html로 이동
    }

}