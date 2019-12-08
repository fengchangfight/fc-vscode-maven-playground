package com.fcvscodemvn.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.sql.SQLException;

@Slf4j
public class Log4jExample {

    // /* Get actual class name to be printed on */
    // static Logger log = Logger.getLogger(Log4jExample.class.getName());

    public static void main(String[] args) throws IOException, SQLException {
        log.debug("Hello this is a debug message: " + System.currentTimeMillis());
        log.info("Hello this is an info message: " + System.currentTimeMillis());
    }
}