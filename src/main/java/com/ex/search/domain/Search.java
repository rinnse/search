package com.ex.search.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.Name;

@Getter
@Setter
@Entity
public class Search {

    @Id
    private int id;

    private String name;

    private String category;


}
