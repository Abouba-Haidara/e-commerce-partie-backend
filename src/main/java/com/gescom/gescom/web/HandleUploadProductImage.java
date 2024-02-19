package com.gescom.gescom.web;

import com.gescom.gescom.dto.ResponseProductImage;
import com.gescom.gescom.entities.ProductImage;
import com.gescom.gescom.services.UploadImageService;
import com.gescom.gescom.utils.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/api")
@CrossOrigin("*")
@Slf4j(topic = "IMAGE_UPLOAD_CONTROLLER")
public class HandleUploadProductImage {
   private final UploadImageService uploadImageService;
    HandleUploadProductImage(final UploadImageService uploadImageService) {
        this.uploadImageService = uploadImageService;
    }

    @PostMapping("/store/images")
    public ResponseEntity<ResponseMessage> uploadImageIntoDatabase(@RequestParam("files") @Validated MultipartFile file, @RequestParam("productId") long productId) {
        String message = "";
        try {

            uploadImageService.uploadImage(file, productId);

            message = "uploaded  Successfully ";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!" + " " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/images/product/{productId}")
    public ResponseEntity<List<ResponseProductImage>> downloadAllImageByProduct(@Validated @PathVariable("productId") long productId) {
        List<ResponseProductImage> files =
                uploadImageService.loadAllImagesByProduct(productId)
            .map(image -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/images/")
                    .path(""+ image.getId())
                    .toUriString();

            return new ResponseProductImage(
                    image.getName(),
                    fileDownloadUri,
                    image.getType(),
                    image.getImage().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> downloadOneImage(@Validated @PathVariable long id) {
        ProductImage image = uploadImageService.getOneImage(id);
        return ResponseEntity.ok()
          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
          .body(image.getImage());
    }

}
