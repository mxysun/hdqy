package top.xym.springboot.wenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xym.springboot.wenda.mapper.CollectionsMapper;

import java.util.List;

@Service
public class CollectionsService {
    @Autowired
    private CollectionsMapper collectionsMapper;

    public List<Integer> findCollectedArticleIdsByUserId(Integer userId) {
        return collectionsMapper.findCollectedArticleIdsByUserId(userId);
    }
}
