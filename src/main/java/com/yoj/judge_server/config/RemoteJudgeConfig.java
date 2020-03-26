package com.yoj.judge_server.config;

import com.yoj.judge_server.controller.LocalController;
import com.yoj.judge_server.controller.RemoteController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix="judge",name = "local", havingValue = "false")
public class RemoteJudgeConfig {
}
