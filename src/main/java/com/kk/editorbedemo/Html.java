package com.kk.editorbedemo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Html {

    @Id @GeneratedValue
    private Long id;

    @Column(columnDefinition = "text")
    private String contents;

    public Html(String contents) {
        this.contents = contents;
    }

    public void updateContents(String contents){
        this.contents = contents;
    }
}
