package com.green.smartGrade.security.todo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/todo-api")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService SERVICE;

//    @PostMapping
//    public int insTodo(@AuthenticationPrincipal MyUserDetails user, @RequestParam String ctnt) {
//        log.info("TodoController - insTodo: ctnt {}", ctnt);
//        log.info("controller-iuser : {}", user.getIuser());
//        SERVICE.test();
//        return 1;
//    }
}
