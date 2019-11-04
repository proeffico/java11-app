package com.springboot.ibiza.surveyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ibiza.surveyapp.jpa.beans.UserBean;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Long> {

}
