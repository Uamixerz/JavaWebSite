package org.example.storage;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileSystemStorageService implements StorageService {
    private final Path rootLocation;
    int [] imageSize = {32, 150, 300, 600, 1200};

    private FileSystemStorageService(StorageProperties storageProperties){
        rootLocation= Paths.get(storageProperties.getFolder());
    }
    @Override
    public void init() {
        try{
            if(!Files.exists(rootLocation))
            {
                Files.createDirectory(rootLocation);
            }
        }catch (IOException e){
            throw new StorageException("Помилка створення");
        }
    }

    @Override
    public void removeFile(String removeFile) {

    try {
        for(var size : imageSize)
        {
            String newFilePath =  size + "_" + removeFile;
            Path filePath = load(newFilePath);

            File file = new File(filePath.toString());
            if(file.delete()){
                System.out.println("--- delete image succsess ---");
            }
        }
    }catch (Exception ex)
    {
        throw new StorageException("файл не знайлено", ex);
    }
    }

    @Override
    public Path load(String fileName) {
        return rootLocation.resolve(fileName);
    }


    @Override
    public String saveImage(MultipartFile file) {
        try {
            String extension = "webp";
            String randomFilename = UUID.randomUUID().toString() + "." + extension;

            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            for(int size : imageSize) {
                String fileOutputSize = rootLocation.toString()+"/"+size+"_"+randomFilename;
                Thumbnails.of(bufferedImage)
                        .size(size, size)
                        .outputFormat(extension)
                        .toFile(fileOutputSize);
            }
            return randomFilename;
        } catch(IOException e) {
            throw new StorageException("Проблема перетвоення файлу!", e);
        }
    }
}
