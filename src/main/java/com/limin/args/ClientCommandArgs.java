package com.limin.args;

import com.beust.jcommander.Parameter;

import lombok.Getter;
import lombok.Setter;

/**
 * 命令行参数
 *
 * @author limin
 * @since 2025-01-06
 */
@Getter
@Setter
public class ClientCommandArgs extends CommandArgs {
    @Parameter(
            names = {"-i", "--input"},
            description = "the input hocon file path",
            required = true)
    private String inputPath;

    @Parameter(
            names = {"-o", "--output"},
            description = "the output json file path",
            required = true)
    private String outputPath;
}
