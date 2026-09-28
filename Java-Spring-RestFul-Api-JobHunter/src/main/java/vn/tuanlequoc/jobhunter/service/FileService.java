package vn.tuanlequoc.jobhunter.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    // lấy base path từ application.properties
    @Value("${tuanlequoc.upload-file.base-uri}")
    private String baseUri;

    private Path getBasePath() throws URISyntaxException {
        return Paths.get(new URI(baseUri));
    }

    // tạo folder nếu chưa tồn tại
    public void createUploadFolder(String folder) throws URISyntaxException {
        Path path = Paths.get(new URI(folder));
        File tmpDir = new File(path.toString());
        if (!tmpDir.isDirectory()) {
            try {
                Files.createDirectories(tmpDir.toPath());
                System.out.println(">>> CREATE NEW DIRECTORY SUCCESSFUL, PATH = " + tmpDir.toPath() + " " + folder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(">>> SKIP MAKING DIRECTORY, ALREADY EXISTS");
        }
    }

    // lưu file upload
    public String store(MultipartFile file, String folder) throws URISyntaxException,
            IOException {
        // tạo tên unique tránh trùng
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename() == null ? "upload" : file.getOriginalFilename());
        String finalName = System.currentTimeMillis() + "-" + originalFilename;
        Path path = getBasePath().resolve(folder).resolve(finalName);
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, path,
                    StandardCopyOption.REPLACE_EXISTING);
        }
        return finalName;
    }

    // lấy size file
    public long getFileLength(String fileName, String folder) throws URISyntaxException {
        Path path = getBasePath().resolve(folder).resolve(fileName);
        File tmpDir = new File(path.toString());
        if (!tmpDir.exists() || tmpDir.isDirectory())
            return 0;
        return tmpDir.length();
    }

    // trả file về cho client (download)
    public InputStreamResource getResource(String fileName, String folder)
            throws FileNotFoundException, URISyntaxException {
        Path path = getBasePath().resolve(folder).resolve(fileName);
        File file = new File(path.toString());
        return new InputStreamResource(new FileInputStream(file));
    }

}
