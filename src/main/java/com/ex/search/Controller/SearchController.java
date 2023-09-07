package com.ex.search.Controller;

import com.ex.search.Repository.SearchRepository;
import com.ex.search.domain.SearchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchRepository searchRepository;

    @GetMapping("/search")         //  templates -> search 패키지 -> search.html 경로니까
    public String search() {
        return "search/search"; // search.html로 이동
    }

    @GetMapping("/list")
    public String list(@RequestParam("keyword") String keyword, Model model) {
        List<SearchEntity> restaurants = searchRepository.findByNameContaining(keyword);
        model.addAttribute("restaurants", restaurants);
        return "list"; // list.html로 이동
    }
}

