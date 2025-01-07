package com.limin;

import com.beust.jcommander.JCommander;

import com.limin.args.ClientCommandArgs;
import com.limin.args.CommandArgs;

/**
 * 入口类
 *
 * @author limin
 * @since 2025-01-06
 */
public class Main {
    public static void main(String[] args) {
        ClientCommandArgs clientCommandArgs = new ClientCommandArgs();
        JCommander jCommander = JCommander.newBuilder()
                .addObject(clientCommandArgs)
                .acceptUnknownOptions(true)
                .build();
        jCommander.parse(args);
        clientCommandArgs.setOriginalParameters(jCommander.getUnknownOptions());
        if (clientCommandArgs.isHelp()) {
            jCommander.usage();
            return;
        }
        if (clientCommandArgs.isVersion()) {
            System.out.println("welcome to use format converter, current version is " + CommandArgs.VERSION);
            return;
        }
        ConvertUtil.convertHoconToJson(clientCommandArgs.getInputPath(), clientCommandArgs.getOutputPath());
    }
}
