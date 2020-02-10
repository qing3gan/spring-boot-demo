package com.agony.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

/**
 * PostMapping = RequestMapping(post)
 *
 * @author agony
 * @date 2020/1/14 23:01
 */
@RestController
public class FileUploadController {
    private static final Log logger = LogFactory.getLog(FileUploadController.class);

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] uploadFiles, HttpServletRequest req) {
        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = LocalDate.now().toString();
        File folder = new File(realPath + format);
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                return "上传失败";
            }
        }
        try {
            for(MultipartFile uploadFile : uploadFiles){
                String oldName = uploadFile.getOriginalFilename();
                String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf('.'));
                uploadFile.transferTo(new File(folder, newName));
                String filePath = String.format("%s://%s:%d/uploadFile/%s/%s", req.getScheme(), req.getServerName(), req.getServerPort(), format, newName);
                logger.info(filePath);
            }
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
