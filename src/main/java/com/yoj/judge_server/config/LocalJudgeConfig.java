package com.yoj.judge_server.config;

import com.yoj.judge_server.controller.LocalController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix="judge",name = "local", havingValue = "true")
@ConditionalOnMissingBean(RemoteJudgeConfig.class)
public class LocalJudgeConfig {

}
