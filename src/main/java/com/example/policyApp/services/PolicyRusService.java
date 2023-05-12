package com.example.policyApp.services;

import com.example.policyApp.entities.policyBY.PolicyBYRepo;
import com.example.policyApp.entities.policyRU.PolicyRURepo;
import com.example.policyApp.entities.policyRU.RussianPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PolicyRusService {

    private final PolicyRURepo ruRepo;

    public Map<String, String> getTotalMessageForRusPolicy(String registrationNumber, String policyNumber) {
        Map<String, String> responseBody = new HashMap<>();
        String message;
        if (!registrationNumber.equals("")) {
            // Если передан регистрационный номер
            Optional<RussianPolicy> optionalPolicy = ruRepo.findByRegistrationNumber(registrationNumber);
            if (optionalPolicy.isPresent()) {
                RussianPolicy policy = optionalPolicy.get();
                message = createRusMessage(policy);
                responseBody.put("message", message);
                return responseBody;
            } else {
                responseBody.put("message", "Не существует");
                return responseBody;
            }
        } else if (!policyNumber.equals("")) {
            Optional<RussianPolicy> optionalPolicy = ruRepo.findByPolicyNumber(policyNumber);
            if (optionalPolicy.isPresent()) {
                RussianPolicy policy = optionalPolicy.get();
                message = createRusMessage(policy);
                responseBody.put("message", message);
                return responseBody;
            } else {
                responseBody.put("message", "Не существует");
                return responseBody;
            }
        }
        else {
            responseBody.put("message", "Не передан ни регистрационный номер, ни номер полиса");
            return responseBody;
        }
    }

    private String createRusMessage(RussianPolicy policy) {
        return "Номер страхового полиса: " + policy.getPolicyNumber()+ "\n" +
                "Дата начала страхования: " + policy.getStartInsurance() + "\n" +
                "Дата окончания страхования: " + policy.getEndInsurance() + "\n" +
                "Страхователь: " + policy.getPolicyHolder() + "\n" +
                "Номер шасси: " + policy.getWinNumber() + "\n" +
                "Регистрационный номер: " + policy.getRegistrationNumber() + "\n" +
                "Серия водительского удостоверения: " + policy.getDrivingLicenseSeries() + "\n" +
                "Номер водительского удостоверения: " + policy.getDrivingLicenseNumber() + "\n" +
                "Особые отметки: " + policy.getSpecialMarks();


    }

}
