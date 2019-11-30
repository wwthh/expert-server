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
    public String insertExpert(@RequestBody String requestbody) {
        System.out.println("insertExpert");
        Map<String, Object> params = new HashMap<>();
        try {
            JSONObject obj = JSON.parseObject(requestbody);
            Expert expert = JSON.toJavaObject(obj, Expert.class);
            expertRepository.insert(expert);
            params.put("success", true);
            params.put("content", expert.toString());
        } catch (Exception e) {
            params.put("success", false);
            Map<String, Integer> contont = new HashMap<>();
            contont.put("error_code", 0);
            params.put("contont", contont);
        }
        return JSONObject.toJSONString(params);
    }

    @GetMapping("/experts/{_id}")
    public String getExpertById(@PathVariable(required = true) String _id, @RequestParam(name = "token", required = true) String token) {
        System.out.println("GetExpertById" + _id);
        Map<String, Object> params = new HashMap<>();
        try {
            Optional<Expert> Oexpert = expertRepository.findById(_id);
            Expert expert = Oexpert.get();
            if (!Oexpert.isPresent()) {
                params.put("success", false);
                Map<String, Integer> contont = new HashMap<>();
                contont.put("error_code", -1);
                params.put("contont", contont.toString());
            } else {
                params.put("success", true);
                System.out.println(expert.toString());
                params.put("content", expert);
            }
        } catch (Exception e) {
            params.put("success", false);
            Map<String, Integer> contont = new HashMap<>();
            contont.put("error_code", 0);
            params.put("contont", contont);
        }

        return JSONObject.toJSONString(params);
    }


    @GetMapping("/experts")
    public String getExpertByPage(@RequestParam(name = "size", required = true) int size,// 每页数量
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
            if (sort == null) sort = "id";


            Sort.Order order = new Sort.Order(Sort.Direction.ASC, sort);
            if (!direction)
                order = new Sort.Order(Sort.Direction.DESC, sort);
            PageRequest pageable = PageRequest.of(page - 1, size, Sort.by(order));
            int count = 0;
            List<Expert> experts = null;
            switch (domain) {
                case "department":
                    experts = expertRepository.findByDepartmentLike(key, pageable).getContent();
                    count = expertRepository.countByDepartmentLike(key);
                    break;
                case "profile":
                    experts = expertRepository.findByProfileLike(key, pageable).getContent();
                    count = expertRepository.countByProfileLike(key);
                    break;
                case "phone":
                    experts = expertRepository.findByPhone(key, pageable).getContent();
                    count = expertRepository.countByPhoneLike(key);
                    break;
                case "name":
                    experts = expertRepository.findByNameLike(key, pageable).getContent();
                    count = expertRepository.countByNameLike(key);
                    break;
                case "email":
                case "e_mail":
                    experts = expertRepository.findByEmail(key, pageable).getContent();
                    count = expertRepository.countByEmailLike(key);
                    break;
                case "position":
                    experts = expertRepository.findByPositionLike(key, pageable).getContent();
                    count = expertRepository.countByPositionLike(key);
                    break;
                default:
                    params.put("success", false);
                    Map<String, Integer> contont = new HashMap<>();
                    contont.put("error_code", 2);
                    params.put("contont", contont);
                    return JSONObject.toJSONString(params);
            }
            assert experts != null;
            if (experts.isEmpty()) {
                System.out.println("Get No Answer ");
                params.put("success", false);
                Map<String, Integer> contont = new HashMap<>();
                contont.put("error_code", 1);
                params.put("contont", contont);
            } else {
                System.out.println("Get! "+ experts);
                params.put("success", true);
                Map<String, Object> contont = new HashMap<>();
                contont.put("total", count);
                contont.put("papers", experts);
                params.put("contont", contont);
            }
        } catch (Exception e) {
            System.out.println("ERROR! " + e.getMessage());
            params.put("success", false);
            Map<String, Integer> contont = new HashMap<>();
            contont.put("error_code", 0);
            params.put("contont", contont);
        }


        return JSONObject.toJSONString(params);
    }


}
