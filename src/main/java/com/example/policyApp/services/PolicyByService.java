package com.example.policyApp.services;

import com.example.policyApp.entities.policyBY.BelarusPolicy;
import com.example.policyApp.entities.policyBY.PolicyBYRepo;
import com.example.policyApp.entities.policyRU.RussianPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PolicyByService {

    private final PolicyBYRepo byRepo;

    public Map<String, String> getTotalMessageForByPolicy(String registrationNumber, String policyNumber) {
        Map<String, String> responseBody = new HashMap<>();
        String message;
        if (!registrationNumber.equals("")) {
            // Если передан регистрационный номер
            Optional<BelarusPolicy> optionalPolicy = byRepo.findByRegistrationNumber(registrationNumber);
            if (optionalPolicy.isPresent()) {
                BelarusPolicy policy = optionalPolicy.get();
                message = createRusMessage(policy);
                responseBody.put("message", message);
                return responseBody;
            } else {
                responseBody.put("message", "Не существует");
                return responseBody;
            }
        } else if (!policyNumber.equals("")) {
            Optional<BelarusPolicy> optionalPolicy = byRepo.findByPolicyNumber(policyNumber);
            if (optionalPolicy.isPresent()) {
                BelarusPolicy policy = optionalPolicy.get();
                message = createRusMessage(policy);
                responseBody.put("message", message);
                return responseBody;
            } else {
                responseBody.put("message", "Не существует");
                return responseBody;
            }
        }
        responseBody.put("message", "Не передан ни регистрационный номер, ни номер полиса");
        return responseBody;
    }

    private String createRusMessage(BelarusPolicy policy) {
        return "Номер страхового полиса: " + policy.getPolicyNumber()+ "\n" +
                "Дата начала страхования: " + policy.getStartInsurance() + "\n" +
                "Дата окончания страхования: " + policy.getEndInsurance() + "\n" +
                "Страхователь: " + policy.getPolicyHolderFullName() + "\n" +
                "Номер шасси: " + policy.getWinNumber() + "\n" +
                "Регистрационный номер: " + policy.getRegistrationNumber() + "\n" +
                "Владелец полиса: " + policy.getOwnerFullName() + "\n" ;


    }

}
