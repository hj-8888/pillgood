package com.kit.pillgood.repository;

import com.kit.pillgood.domain.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
        List<Disease> findByDiseaseCode(String diseaseCode);
}
