package com.expedia.common;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;

public final class ClasspathUtils {

    public static byte[] loadResource(String path) throws Exception {
        URL url = ClassLoader.getSystemResource(path);
        assert url != null : format("Resource %s not found", path);
        String decodedPath = URLDecoder.decode(url.getFile(), UTF_8.name());
        return Files.readAllBytes(new File(decodedPath).toPath());
    }
}
