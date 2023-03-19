package com.xwl.common.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @Author: xwl
 * @Date: 2023-03-18 21:12:41
 * @Desc: todo Properties
 */


@Slf4j
public class PropertiesFileUtil {

    private PropertiesFileUtil() {

    }

    /**
     * 返回配置信息
     *
     * @param fileName
     * @return
     */
    public static Properties readPropertiesFile(String fileName) {

        /**
         * todo ?? 类加载器 - application->bootstrap->root
         */
        URL url = Thread.currentThread()
                .getContextClassLoader()
                .getResource("");

        String rpcConfigPath = "";

        if (url != null) {
            rpcConfigPath = url.getPath() + fileName;
        }

        Properties properties = null;
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(rpcConfigPath),
                StandardCharsets.UTF_8)) {

            // 配置文件加载
            properties = new Properties();
            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            log.error("occur exception when read properties file [{}]", fileName);
        }

        return properties;
    }
}
