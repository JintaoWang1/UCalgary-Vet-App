package com.repository;

import com.model.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalDao extends PagingAndSortingRepository<Animal, Integer> {
    @Query(value = "SELECT * FROM animal WHERE status = 'Available'", nativeQuery = true)
    Iterable<Animal> findAnimalByStatus();


    @Query(value = "SELECT * FROM animal ", nativeQuery = true)
    Page<Animal> searchAnimalByPage(Pageable pageable);
}
