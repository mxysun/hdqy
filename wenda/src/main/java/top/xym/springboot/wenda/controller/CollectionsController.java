package top.xym.springboot.wenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.wenda.service.CollectionsService;

import java.util.List;
@RestController
public class CollectionsController {
    @Autowired
    private CollectionsService collectionsService;

    @GetMapping("/collections/{userId}")
    public List<Integer> getCollectedArticleIdsByUserId(@PathVariable Integer userId) {
        return collectionsService.findCollectedArticleIdsByUserId(userId);
    }
}
