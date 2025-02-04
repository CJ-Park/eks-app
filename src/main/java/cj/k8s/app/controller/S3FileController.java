package cj.k8s.app.controller;

import cj.k8s.app.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/s3")
public class S3FileController {

    private final S3Service s3Service;

    @PostMapping(value = "/files")
    public void uploadS3File(@RequestPart("file") MultipartFile file) {
        try {
            s3Service.uploadS3File(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/files/{fileNo}")
    public ResponseEntity<Resource> downloadS3File(@PathVariable("fileNo") long fileNo) throws Exception {
        return s3Service.downloadS3File(fileNo);
    }
}
