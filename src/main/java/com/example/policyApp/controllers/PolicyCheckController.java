package com.example.policyApp.controllers;

import com.example.policyApp.configs.JWTService;
import com.example.policyApp.controllers.request.RequestDTO;
import com.example.policyApp.entities.policyBY.BelarusPolicy;
import com.example.policyApp.entities.policyBY.PolicyBYRepo;
import com.example.policyApp.entities.policyRU.PolicyRURepo;
import com.example.policyApp.entities.policyRU.RussianPolicy;
import com.example.policyApp.entities.user.UserRepo;
import com.example.policyApp.services.PolicyByService;
import com.example.policyApp.services.PolicyRusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/policy_check")
@RequiredArgsConstructor
public class PolicyCheckController {

    private final PolicyBYRepo byRepo;
    private final PolicyByService policyByService;
    private final PolicyRURepo ruRepo;
    private final PolicyRusService policyRusService;


    @PostMapping(value = "/russian", consumes = "application/json")
    public ResponseEntity<Map<String, String>> sendRusPolicy(@RequestBody RequestDTO requestDTO) {
        String role = requestDTO.role;
        String registrationNumber = requestDTO.registrationNumber;
        String policyNumber = requestDTO.contractNumber;
        Map<String, String> responseBody = new HashMap<>();
        if (role.equals("USER_ROLE")) {
            responseBody = policyRusService
                    .getTotalMessageForRusPolicy(registrationNumber, policyNumber);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(responseBody);
        }

        if (!registrationNumber.equals("")) {
            // Если передан регистрационный номер
            Optional<RussianPolicy> optionalPolicy = ruRepo.findByRegistrationNumber(registrationNumber);
            if (optionalPolicy.isPresent()) {
                RussianPolicy policy = optionalPolicy.get();
                Date termOfInsurance = policy.getEndInsurance();
                LocalDateTime termOfInsuranceLocalDateTime = LocalDateTime.ofInstant(termOfInsurance.toInstant(), ZoneId.systemDefault());
                LocalDateTime now = LocalDateTime.now();
                int nowYear = now.getYear();
                int termOfInsuranceYear = termOfInsuranceLocalDateTime.getYear();
                //Определение года
                // -1 значит страховка закончилась в прошлом году
                //0 значит страховка этого года
                //1 значит страховка закончится в следующем году
                int isYearBefore = Integer.compare(termOfInsuranceYear, nowYear);
                if (isYearBefore == -1) {
                    responseBody.put("message", "Полис не действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                }
                boolean isTimeBefore = termOfInsuranceLocalDateTime.isBefore(now);
                if (isYearBefore == 0 && isTimeBefore) {
                    responseBody.put("message", "Полис не действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                } else {
                    responseBody.put("message", "Полис  действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                }
            } else {
                responseBody.put("message", "Полис не cуществует");
                return ResponseEntity.status(HttpStatus.OK)
                        .body(responseBody);
            }
            //Если передан номер полиса
        } else if (!policyNumber.equals("")) {
            Optional<RussianPolicy> optionalPolicy = ruRepo.findByPolicyNumber(policyNumber);
            if (optionalPolicy.isPresent()) {
                RussianPolicy policy = optionalPolicy.get();
                Date termOfInsurance = policy.getEndInsurance();
                LocalDateTime termOfInsuranceLocalDateTime = LocalDateTime.ofInstant(termOfInsurance.toInstant(), ZoneId.systemDefault());
                LocalDateTime now = LocalDateTime.now();
                int nowYear = now.getYear();
                int termOfInsuranceYear = termOfInsuranceLocalDateTime.getYear();
                //Определение года
                // -1 значит страховка закончилась в прошлом году
                //0 значит страховка этого года
                //1 значит страховка закончится в следующем году
                int isYearBefore = Integer.compare(termOfInsuranceYear, nowYear);
                if (isYearBefore == -1) {
                    responseBody.put("message", "Полис не действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                }
                boolean isTimeBefore = termOfInsuranceLocalDateTime.isBefore(now);
                if (isYearBefore == 0 && isTimeBefore) {
                    responseBody.put("message", "Полис не действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                } else {
                    responseBody.put("message", "Полис  действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                }
            }
        }
        responseBody.put("message", "Не передан ни регистрационный номер, ни номер полиса");
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseBody);
    }

    @PostMapping(value = "/belarusian", consumes = "application/json")
    public ResponseEntity<Map<String, String>> sendBelPolicy(@RequestBody RequestDTO requestDTO) {
        String role = requestDTO.role;
        String registrationNumber = requestDTO.registrationNumber;
        String policyNumber = requestDTO.contractNumber;
        Map<String, String> responseBody = new HashMap<>();
        if (role.equals("USER_ROLE")) {
            responseBody = policyByService
                    .getTotalMessageForByPolicy(registrationNumber, policyNumber);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(responseBody);
        }

        if (!registrationNumber.equals("")) {
            // Если передан регистрационный номер
            Optional<BelarusPolicy> optionalPolicy = byRepo.findByRegistrationNumber(registrationNumber);
            if (optionalPolicy.isPresent()) {
                BelarusPolicy policy = optionalPolicy.get();
                Date termOfInsurance = policy.getEndInsurance();
                LocalDateTime termOfInsuranceLocalDateTime = LocalDateTime.ofInstant(termOfInsurance.toInstant(), ZoneId.systemDefault());
                LocalDateTime now = LocalDateTime.now();
                int nowYear = now.getYear();
                int termOfInsuranceYear = termOfInsuranceLocalDateTime.getYear();
                //Определение года
                // -1 значит страховка закончилась в прошлом году
                //0 значит страховка этого года
                //1 значит страховка закончится в следующем году
                int isYearBefore = Integer.compare(termOfInsuranceYear, nowYear);
                if (isYearBefore == -1) {
                    responseBody.put("message", "Полис не действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                }
                boolean isTimeBefore = termOfInsuranceLocalDateTime.isBefore(now);
                if (isYearBefore == 0 && isTimeBefore) {
                    responseBody.put("message", "Полис не действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                } else {
                    responseBody.put("message", "Полис  действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                }
            } else {
                responseBody.put("message", "Полис не cуществует");
                return ResponseEntity.status(HttpStatus.OK)
                        .body(responseBody);
            }
            //Если передан номер полиса
        } else if (!policyNumber.equals("")) {
            Optional<BelarusPolicy> optionalPolicy = byRepo.findByPolicyNumber(policyNumber);
            if (optionalPolicy.isPresent()) {
                BelarusPolicy policy = optionalPolicy.get();
                Date termOfInsurance = policy.getEndInsurance();
                LocalDateTime termOfInsuranceLocalDateTime = LocalDateTime.ofInstant(termOfInsurance.toInstant(), ZoneId.systemDefault());
                LocalDateTime now = LocalDateTime.now();
                int nowYear = now.getYear();
                int termOfInsuranceYear = termOfInsuranceLocalDateTime.getYear();
                //Определение года
                // -1 значит страховка закончилась в прошлом году
                //0 значит страховка этого года
                //1 значит страховка закончится в следующем году
                int isYearBefore = Integer.compare(termOfInsuranceYear, nowYear);
                if (isYearBefore == -1) {
                    responseBody.put("message", "Полис не действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                }
                boolean isTimeBefore = termOfInsuranceLocalDateTime.isBefore(now);
                if (isYearBefore == 0 && isTimeBefore) {
                    responseBody.put("message", "Полис не действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                } else {
                    responseBody.put("message", "Полис  действительный");
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(responseBody);
                }
            }
        }
        responseBody.put("message", "Не передан ни регистрационный номер, ни номер полиса");
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseBody);
    }

}
