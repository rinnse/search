package com.ex.search.Controller;

import com.ex.search.Service.SearchService;
import com.ex.search.domain.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        List<Search> restaurants = searchService.searchRestaurants(name);
        model.addAttribute("restaurants", restaurants);
        return "/search/list"; // list.html로 이동
    }


    // 서버에서 검색어 처리 기능
    @RequestMapping("suggestions")
    @ResponseBody
    public List<Search> suggestions(@RequestParam("name") String name) {
        List<Search> suggestions = searchService.getSuggestions(name);
        return suggestions;
    }

}