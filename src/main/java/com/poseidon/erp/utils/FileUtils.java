package com.poseidon.erp.utils;

import com.poseidon.erp.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author mario on 2020/5/18
 */
@Slf4j
@Component
public class FileUtils {

    private static String filePath;
    private static String thumbnailFilePath;

    public static String upload(MultipartFile file) {
        try {

            String fileName = file.getOriginalFilename();
            assert fileName != null;
            String suffixName = fileName.substring(fileName.lastIndexOf('.'));
            String name = UUID.randomUUID().toString().replace("-", "");
            fileName = name + suffixName;
            File dest = new File(filePath + fileName);
            checkDir(dest);

            File thumbnail = new File(thumbnailFilePath);
            thumbnail.mkdir();
            Thumbnails.of(file.getInputStream()).scale(1.0f)
                    .outputQuality(0.8f)
                    .outputFormat(suffixName.replace(".", ""))
                    .toFile(thumbnail + File.separator + name);
            file.transferTo(dest);
            return fileName;
        } catch (IOException e) {
            log.error("上传失败:" + e);
            throw new BusinessException(ResponseCode.MEDIA_UPLOAD_FAIL);
        }

    }

    public static String upload(File file) {
        try {
            File dest = new File(filePath + file.getName());
            checkDir(dest);

            Files.copy(file.toPath(), dest.toPath());
            return file.getName();
        } catch (IOException e) {
            log.error("上传失败:" + e);
            throw new BusinessException(ResponseCode.MEDIA_UPLOAD_FAIL);
        }
    }

    public static void delete(String fileName) {
        try {
            Files.deleteIfExists(Paths.get(filePath + fileName));
            Files.deleteIfExists(Paths.get(thumbnailFilePath + fileName));
        } catch (IOException e) {
            log.error("删除失败:" + e);
            throw new BusinessException(ResponseCode.MEDIA_DELETE_FAIL);
        }

    }

    @Value("${file.path}")
    public void setFilePath(String filePath) {
        FileUtils.filePath = filePath;
    }

    @Value("${file.thumbnailPath}")
    public void setThumbnailFilePath(String thumbnailFilePath) {
        FileUtils.thumbnailFilePath = thumbnailFilePath;
    }

    public static void checkDir(File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }
}
