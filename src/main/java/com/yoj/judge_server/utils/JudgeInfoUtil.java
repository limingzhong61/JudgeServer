package com.yoj.judge_server.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class JudgeInfoUtil {
    @Value("${backend.url}")
    private String backendUrl;
}
