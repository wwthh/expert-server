package com.wwt.expertservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wwt.expertservice.model.Expert;
import com.wwt.expertservice.model.ExpertRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ExpertController {


    @Autowired
    private ExpertRepository expertRepository;

    @PostMapping("/experts")
    public Map<String, Object> insertExpert(@RequestBody String requestbody) {
        System.out.println("insertExpert");
        Map<String, Object> params = new HashMap<>();
        try {
            JSONObject obj = JSON.parseObject(requestbody);
            Expert expert = JSON.toJavaObject(obj, Expert.class);
            expertRepository.insert(expert);
            params.put("success", true);
            params.put("content", expert);
        } catch (Exception e) {
            System.out.println("ERROR" + e.getMessage());
            params.put("success", false);
            Map<String, Integer> content = new HashMap<>();
            content.put("error_code", 0);
            params.put("content", content);
        }
        return params;
    }

    @GetMapping("/experts/{_id}")
    public Map<String, Object> getExpertById(@PathVariable(required = true) String _id, @RequestParam(name = "token", required = false) String token) {
        System.out.println("GetExpertById" + _id);
        Map<String, Object> params = new HashMap<>();
        try {
            Optional<Expert> Oexpert = expertRepository.findById(_id);
            Expert expert = Oexpert.get();
            if (!Oexpert.isPresent()) {
                params.put("success", false);
                Map<String, Integer> content = new HashMap<>();
                content.put("error_code", -1);
                params.put("content", content.toString());
            } else {
                params.put("success", true);
                System.out.println(expert);
                params.put("content", JSONObject.parseObject(expert.toString()));
            }
        } catch (Exception e) {
            params.put("success", false);
            Map<String, Integer> content = new HashMap<>();
            content.put("error_code", 0);
            params.put("content", content);
        }
        return params;
    }


    @GetMapping("/experts")
    public Map<String, Object> getExpertByPage(@RequestParam(name = "size", required = true) int size,// 每页数量
                                  @RequestParam(name = "page", required = true) int page, // 第几页
                                  @RequestParam(name = "domain", required = false) String domain, // 搜索字段 i.e. name
                                  @RequestParam(name = "key", required = true) String key, // 搜索key
                                  @RequestParam(name = "sort", required = false) String sort, // 排序字段
                                  @RequestParam(name = "direction", required = false) boolean direction,// 排序顺序 true - 大到小；false - 小到大
                                  @RequestParam(name = "free", required = false) boolean free
    ) {
        System.out.println("getExpertByPage");
        Map<String, Object> params = new HashMap<>();
        try {
            if (domain == null) domain = "name";
            if (sort == null) sort = "name";
            Sort.Order order = new Sort.Order(Sort.Direction.DESC, sort);
            if (!direction)
                order = new Sort.Order(Sort.Direction.ASC, sort);
            PageRequest pageable = PageRequest.of(page - 1, size, Sort.by(order));
            int count = 0;
            List<Expert> experts = null;
            switch (domain) {
                case "name":
                    experts = expertRepository.findByNameLike(key, pageable).getContent();
                    count = expertRepository.countByNameLike(key);
                    break;
                case "org":
                    experts = expertRepository.findByOrgLike(key, pageable).getContent();
                    count = expertRepository.countByOrgLike(key);
                    break;


                default:
                    params.put("success", false);
                    Map<String, Integer> content = new HashMap<>();
                    content.put("error_code", 2);
                    params.put("content", content);
                    return params;
            }
            assert experts != null;
            if (experts.isEmpty()) {
                System.out.println("Get No Answer ");
                params.put("success", false);
                Map<String, Integer> content = new HashMap<>();
                content.put("error_code", 1);
                params.put("content", content);
            } else {
                System.out.println("Get! "+ experts);
                params.put("success", true);
                Map<String, Object> content = new HashMap<>();
                content.put("total", count);
                content.put("experts", experts);
                params.put("content", JSONObject.parseObject(content.toString().replace('=',':')));
            }
        } catch (Exception e) {
            System.out.println("ERROR! " + e.getMessage());
            params.put("success", false);
            Map<String, Integer> content = new HashMap<>();
            content.put("error_code", 0);
            params.put("content", content);
        }
        return params;
    }


}
