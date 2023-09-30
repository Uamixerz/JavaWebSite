package org.example.storage;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("store")
public class StorageProperties {
    @Value("${it.step.location}")
    private String folder;
}
