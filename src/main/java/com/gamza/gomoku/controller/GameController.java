package com.gamza.gomoku.controller;

import com.gamza.gomoku.dto.user.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    @PostMapping("/game/test")
    public ResponseEntity<String> receiveJson(@RequestBody LoginRequestDto requestDto) {
        String id = requestDto.getUserEmail();
        String password = requestDto.getPassword();
        System.out.println("Received JSON: " + id + password);
        return ResponseEntity.ok("JSON received successfully");
    }

}
