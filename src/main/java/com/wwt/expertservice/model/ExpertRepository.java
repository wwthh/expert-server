package com.wwt.expertservice.model;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.net.ContentHandler;
import java.util.Optional;

public interface ExpertRepository extends MongoRepository<Expert, String> {


    Page<Expert> findByNameLike(String key, Pageable pageable);

    int countByNameLike(String key);

    Page<Expert> findByOrgLike(String key, PageRequest pageable);

    int countByOrgLike(String key);


}
