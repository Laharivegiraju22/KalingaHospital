package com.mindtree.gooddeedtrackingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mindtree.gooddeedtrackingapplication.entity.CampusMind;

@Service
@Repository
public interface CampusMindRepository extends JpaRepository<CampusMind,Integer>{

}
