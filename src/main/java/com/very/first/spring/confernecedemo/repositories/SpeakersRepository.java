package com.very.first.spring.confernecedemo.repositories;

import com.very.first.spring.confernecedemo.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakersRepository extends JpaRepository<Speaker,Long> {

}
