package com.limin;

import org.apache.seatunnel.shade.com.typesafe.config.Config;
import org.apache.seatunnel.shade.com.typesafe.config.ConfigFactory;
import org.apache.seatunnel.shade.com.typesafe.config.ConfigRenderOptions;
import org.apache.seatunnel.shade.com.typesafe.config.ConfigResolveOptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 转换工具类
 *
 * @author limin
 * @since 2025-01-06
 */
public class ConvertUtil {
    public static String convertHoconToJson(String hocon) {
        Config config = ConfigFactory.parseString(hocon)
                        .resolve(ConfigResolveOptions.defaults().setAllowUnresolved(true));
        return config.root().render(ConfigRenderOptions.concise().setFormatted(true));
    }

    public static void convertHoconToJson(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            System.out.println("the input file is not exist.");
            return;
        }
        File outFile = new File(outputPath);
        File parentFile = outFile.getParentFile();
        if (!parentFile.exists()) {
            boolean success = parentFile.mkdirs();
            if (success) {
                System.out.println("create dir success.");
            }
        }
        if (!outFile.exists()) {
            try {
                boolean success = outFile.createNewFile();
                if (success) {
                    System.out.println("create json file success.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Config config = ConfigFactory.parseFile(inputFile)
                .resolve(ConfigResolveOptions.defaults().setAllowUnresolved(true));
        String json = config.root().render(ConfigRenderOptions.concise().setFormatted(true));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
