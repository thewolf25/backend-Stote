package org.ecommerce.dao;

import org.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface UserRespository extends JpaRepository<User, Integer> {


    public User findByUsername(String s);
}
