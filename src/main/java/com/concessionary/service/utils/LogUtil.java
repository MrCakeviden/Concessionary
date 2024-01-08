package com.concessionary.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class LogUtil
{
    private static final String filePath =
            "C:\\Documents\\Project_Items\\0_Personal\\SpringBoot\\Concessionary_Unmod\\Concessionary\\src\\main\\resources\\templates\\";
    private static final String fileName = "concessionary_log.txt";
    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    private static void fileCheck(String messageToAppend, String logType) {
        File newFile = new File(filePath + fileName);

        if(!newFile.exists())
        {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            StringBuilder msg = new StringBuilder();
            msg.append(LocalDateTime.now()).append(" - ");
            msg.append(logType).append(": ");
            msg.append(messageToAppend).append("\n");

            Files.write(Paths.get(filePath + fileName), msg.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logInfo(String message)
    {
        logger.info(message);
        fileCheck(message, "INFO");
    }

    public static void logWarning(String message)
    {
        logger.warn(message);
        fileCheck(message, "WARN");
    }

    public static void logError(String message)
    {
        logger.error(message);
        fileCheck(message, "ERROR");
    }

    public static void logTrace(String message)
    {
        logger.trace(message);
        fileCheck(message, "TRACE");
    }

}
