package com.ex.search.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;;

@Getter
@Setter
@Entity
public class Search {

    @Id
    private int id;   // 식당 ID

    private String name;   // 식당 명

    private String category;   // 카테고리
}
