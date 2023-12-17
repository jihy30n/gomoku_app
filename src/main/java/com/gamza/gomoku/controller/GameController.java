package com.gamza.gomoku.controller;

import com.gamza.gomoku.dto.user.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    @PostMapping("/login")
    public ResponseEntity<String> receiveJson(@RequestBody LoginRequestDto requestDto) {
        String userEmail = requestDto.getUserEmail();
        String password = requestDto.getPassword();
        return ResponseEntity.ok("JSON received successfully");
    }
}
