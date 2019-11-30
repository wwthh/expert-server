package com.wwt.expertservice.model;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpertRepository extends MongoRepository<Expert, String> {



    Page<Expert> findByDepartmentLike(String key, Pageable pageable);

    Page<Expert> findByProfileLike(String key, Pageable pageable);

    Page<Expert> findByNameLike(String key, Pageable pageable);

    Page<Expert> findByPhone(String key, Pageable pageable);

    Page<Expert> findByEmail(String key, Pageable pageable);

    Page<Expert> findByPositionLike(String key, Pageable pageable);

    int countByDepartmentLike(String key);

    int countByPhoneLike(String key);

    int countByProfileLike(String key);

    int countByNameLike(String key);

    int countByEmailLike(String key);

    int countByPositionLike(String key);
}
