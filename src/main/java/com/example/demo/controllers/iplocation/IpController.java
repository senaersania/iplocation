package com.example.demo.controllers.iplocation;

import com.example.demo.util.ReadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class IpController {
    @Autowired
    ReadFileService readFileService;
    private static String uploadFileLocation = "/Users/sena/Work/Training/demo/src/main/resources/static/uploadedfile/";

    @GetMapping("/iplocation")
    public String ipLocation(){
        readFileService.readFile("/Users/sena/ecs/ecs_ap-southeast-5_sg-k1a09pphn39em9ns91zk.json");
        //readFileService.singleIp();
        return "iplocation/index";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile multipartFile, RedirectAttributes redirectAttributes){
        if (multipartFile.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(uploadFileLocation + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message","You successfully uploaded '" + multipartFile.getOriginalFilename() + "'");
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus(){
        return "iplocation/ips";
    }
}
