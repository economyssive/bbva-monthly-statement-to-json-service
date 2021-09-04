package me.nurio.economyssive.bbva.pdfparser;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class FileHandlerRestController {

    @PostMapping("/csv")
    public String fileHandler(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        List<String> process = BbvaPdfToCsv.process(inputStream);
        return String.join("\n", process);
    }

}