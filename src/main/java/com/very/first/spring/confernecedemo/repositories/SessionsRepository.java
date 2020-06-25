package com.very.first.spring.confernecedemo.repositories;

import com.very.first.spring.confernecedemo.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionsRepository extends JpaRepository<Session,Long> {
}
