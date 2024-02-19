package com.gescom.gescom.services;

import com.gescom.gescom.entities.ProductImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface UploadImageService {
    void uploadImage(MultipartFile file, long productId)  throws IOException;
    Stream<ProductImage> loadAllImagesByProduct(long productId);
    ProductImage getOneImage(long id);
}
