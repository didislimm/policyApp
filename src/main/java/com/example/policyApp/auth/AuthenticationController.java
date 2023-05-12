package com.example.policyApp.auth;

import com.example.policyApp.entities.user.User;
import com.example.policyApp.entities.user.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final  AuthenticationService service;
    private final UserRepo userRepo;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        String username = request.getUsername();
        Optional<User> user=userRepo.findByUsername(username);
        if (user.isPresent()){
            return ResponseEntity.ok(service.authenticate(request));
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthenticationResponse("Пользователь не найден","Anonymous"));
        }

    }

}
