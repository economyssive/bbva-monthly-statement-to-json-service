package me.nurio.economyssive.bbva.pdfparser;

import me.nurio.economyssive.bbva.pdftocsv.BbvaPdfToCsv;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JsonParserRestController {

    @PostMapping("/json")
    public List<JsonParsedResponse> fileHandler(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();

        List<String> process = BbvaPdfToCsv.process(inputStream);
        process.remove(0);

        return process.stream()
            .map(JsonParsedResponse::new)
            .collect(Collectors.toList());
    }

}