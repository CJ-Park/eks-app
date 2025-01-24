package cj.k8s.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @GetMapping("/api/status")
    public String healthCheck() {
        return "EKS - ECR - ArgoCD test";
    }
}
