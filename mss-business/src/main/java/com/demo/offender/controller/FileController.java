package com.demo.offender.controller;

import com.demo.chat.po.FileInfo;
import com.demo.chat.po.QuestionNaire;
import com.demo.offender.service.FileInfoService;
import com.demo.offender.service.QuestionNaireService;
import com.microservice.skeleton.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import com.demo.chat.util.UUID;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/questionnaire")
public class FileController {
    @Resource
    private QuestionNaireService questionNaireService;

    @Value("${filepath}")
    private String filepath;

    private Map<String,String> fileMap = new HashMap();

    @Resource
    private FileInfoService fileInfoService;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/up")
    public Result upData(@RequestParam("file") MultipartFile file){
        //questionNaireService.save(questionNaire);
        File targetFile = new File(filepath);
        String fileName = file.getOriginalFilename();
        log.info(fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try (FileOutputStream out = new FileOutputStream(filepath + file.getOriginalFilename());){
            out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件上传失败!");
            return Result.failure(1000,"uploading failure");
        }
        log.info("文件上传成功!");
        /*String[] allFileName  = fileName.split(".");
        String name = allFileName[0];
        String suffix = allFileName[1];*/
        String uuid = UUID.getUUID();
        fileInfoService.saveFileInfo(FileInfo
                .builder()
                .id(uuid)
                .file_name(fileName)
                .build());
        //fileMap.put("uuid",fileName);
        String result =  "/questionnaire/down/"+uuid;
        List<String> l = new ArrayList();
        l.add(result);
        return Result.ok(l);

    }


    /**
     * 处理文件上传
     */
    /*@PostMapping(value = "/upload")
    public String uploading(@RequestParam("file") MultipartFile file) {
        File targetFile = new File(filepath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try (FileOutputStream out = new FileOutputStream(filepath + file.getOriginalFilename());){
            out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件上传失败!");
            return "uploading failure";
        }
        log.info("文件上传成功!");
        return "uploading success";
    }
*/
    @RequestMapping("/down/{id}")
    public void downLoad(HttpServletResponse response,@PathVariable String id) throws UnsupportedEncodingException {
        FileInfo fileInfo = fileInfoService.findById(id).get();
        String filename = fileInfo.getFile_name();
        //String filename = fileMap.get(id);
        log.info("被下载文件"+filename);
        //String filename="JAVA核心知识点整理.pdf";
        String filePath = filepath;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename,"utf8"));
            byte[] buffer = new byte[1024];
            //输出流
            OutputStream os = null;
            try(FileInputStream fis= new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);) {
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
