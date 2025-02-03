package cj.k8s.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @GetMapping("/api/status")
    public String healthCheck() {
        return "EKS / AWS Storage (DB) / Monitoring (Prometheus / Grafana) with GitOps & ArgoCD";
    }

    @GetMapping("/change/db")
    public String changeDB() {
        return "change db subnet public to private";
    }
}
