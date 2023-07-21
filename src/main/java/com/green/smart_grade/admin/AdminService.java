package com.green.smart_grade.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private final AdminMapper MAPPER;
}
