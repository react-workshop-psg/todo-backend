package com.rest.webservices.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.rest.webservices.model.Todo;



@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo,
        Long>{

}