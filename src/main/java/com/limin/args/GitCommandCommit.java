package com.limin.args;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述
 *
 * @author limin
 * @since 2025-01-07
 */
@Getter
@Setter
@Parameters(commandDescription = "提交文件", commandNames = "commit")
public class GitCommandCommit {
    public static final String COMMAND = "commit";

    @Parameter(names = {"-comment", "-m"},
            description = "请输入注释",
            arity = 1,
            required = true)
    private String comment;
}