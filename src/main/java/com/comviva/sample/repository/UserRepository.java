package com.comviva.sample.repository;

import com.comviva.sample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by arnab.goswami on 13-11-2019.
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
