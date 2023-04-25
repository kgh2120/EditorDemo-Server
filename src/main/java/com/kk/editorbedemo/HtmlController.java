package com.kk.editorbedemo;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@Transactional
public class HtmlController {

    private final Repo repo;


    @PostMapping("/html")
    public String html(@RequestBody Map<String,String> html){
        log.info("html ={} ", html.get("html"));
        repo.save(new Html(html.get("html")));
        return "hi?";
    }

    @GetMapping("/html")
    public List<Html> getHtml(){
        return repo.findAll();
    }

    @GetMapping("/html/{id}")
    public Html getHtml(@PathVariable long id) {
        return repo.findById(id).orElseThrow();
    }

    @PatchMapping("/html")
    public String updateHtml(@RequestBody Map<String,Object> body){
        Html html = repo.findById(Long.parseLong(((Integer)body.get("id")).toString())).orElseThrow();
        html.updateContents((String) body.get("content"));
        return "hi?";
    }
    @DeleteMapping("/html/{id}")
    public void delete(@PathVariable long id) {
        repo.deleteById(id);
    }


}
