package com.green.smart_grade.security.todo;

import com.green.smart_grade.security.config.security.model.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {
    private final AuthenticationFacade facade;

    public void test() {
        log.info("service-test : {}", facade.getLoginUserPk());
    }
}
