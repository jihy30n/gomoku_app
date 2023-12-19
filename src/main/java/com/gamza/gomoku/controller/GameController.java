package com.gamza.gomoku.controller;

import com.gamza.gomoku.dto.game.GameDto;
import com.gamza.gomoku.dto.user.LoginRequestDto;
import com.gamza.gomoku.jwt.JwtProvider;
import com.gamza.gomoku.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
//@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final UserService userService;
    private final JwtProvider jwtProvider;




    //    @PostMapping("/login")
//    public ResponseEntity<String> receiveJson(@RequestBody LoginRequestDto requestDto) {
//        String userEmail = requestDto.getUserEmail();
//        String password = requestDto.getPassword();
//        return ResponseEntity.ok("JSON received successfully");
//        return userService.login(loginRequestDto, response);
//
//    }
    @PostMapping("/game/login")
    public ResponseEntity<String> receiveJson(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response
    ) {
        String userEmail = loginRequestDto.getUserEmail();
        String password = loginRequestDto.getPassword();
        ResponseEntity.ok("JSON received successfully");
        return userService.login(loginRequestDto, response);

    }

    @PostMapping("/game/end")
    public ResponseEntity<String> receiveGameInfo(@RequestBody GameDto gameDto, HttpServletResponse response) {

        String accessToken = gameDto.getAccessToken();
        String outcome = gameDto.getOutcome();

        String userEmail = jwtProvider.getUserEmailFromToken(accessToken);

        userService.processGameData(userEmail, outcome);

        return ResponseEntity.ok("게임종료값 받음");
    }
}
