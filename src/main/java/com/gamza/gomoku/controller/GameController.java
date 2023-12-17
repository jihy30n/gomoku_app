package com.gamza.gomoku.controller;

import com.gamza.gomoku.dto.user.LoginRequestDto;
import com.gamza.gomoku.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final UserService userService;


//    @PostMapping("/login")
//    public ResponseEntity<String> receiveJson(@RequestBody LoginRequestDto requestDto) {
//        String userEmail = requestDto.getUserEmail();
//        String password = requestDto.getPassword();
//        return ResponseEntity.ok("JSON received successfully");
//        return userService.login(loginRequestDto, response);
//
//    }
    @PostMapping("/login")
    public ResponseEntity<String> receiveJson(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response
    ) {
        String userEmail = loginRequestDto.getUserEmail();
        String password = loginRequestDto.getPassword();
        ResponseEntity.ok("JSON received successfully");
        return userService.login(loginRequestDto, response);

    }
}
