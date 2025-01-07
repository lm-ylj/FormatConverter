package com.limin.args;

import com.beust.jcommander.Parameter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 命令行参数
 *
 * @author limin
 * @since 2025-01-06
 */
@Getter
@Setter
public class CommandArgs {
    @Parameter(
            names = {"-h", "--help"},
            help = true,
            description = "Show the usage message")
    protected boolean help = false;

    @Parameter(
            names = {"-v", "--version"},
            help = true,
            description = "Show the version")
    protected boolean version = false;

    public static final String VERSION = "1.0.0";

    // 存储未定义参数
    protected List<String> originalParameters;
}
