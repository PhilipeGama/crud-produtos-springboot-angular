package com.games.controller;

import com.games.entity.UserImg;
import com.games.repository.UserImgRepository;
import com.games.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.Normalizer;

@Controller
public class UploadImageTest {

    @Autowired
    UserImgRepository repo;

    @GetMapping("/upload-img")
    public String Img(){
        return "tests/upload-img-test";
    }

    @PostMapping("/users/save")
    public RedirectView saveUser(UserImg user,
                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        fileName = Normalizer.normalize(fileName, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        fileName = fileName.replaceAll("\\s+","-");
        System.out.println(fileName);

        user.setImageName(fileName);


        UserImg savedUser = repo.save(user);

//        System.out.println(user.toString());



        String uploadDir = "./src/main/resources/static/upload-images/";

//


        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new RedirectView("/upload-img", true);
    }

    @GetMapping("/images/{urlImagemLocal}")
    @ResponseBody
    public byte[] carregaImagensDinamicas(@PathVariable("urlImagemLocal") String nomeImagem) {

        File imagemArquivo = new File("./src/main/resources/static/upload-images/" + nomeImagem);

        try {
            return Files.readAllBytes(imagemArquivo.toPath());
        } catch (IOException e) {
            return null;
        }

    }
}
