package com.lobanov.rest.service;

import com.lobanov.rest.model.Passport;
import com.lobanov.rest.repository.PassportRepository;
import org.springframework.stereotype.Service;

@Service
public class PassportService {

    private  final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public void savePassport(Passport passport) {
        passportRepository.save(passport);


    }
}
