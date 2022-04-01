package com.lobanov.rest.repository;

import com.lobanov.rest.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {

}
