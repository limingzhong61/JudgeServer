package com.yoj.judge_server.controller;

import com.yoj.judge_server.annotation.JudgePermitAnnotation;
import com.yoj.judge_server.model.JudgeSource;
import com.yoj.judge_server.threads.JudgeThreadPoolManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// local prevent high concurrency
@Slf4j
@RestController
@ConditionalOnProperty(prefix="judge",name = "local", havingValue = "true")
public class LocalController {
    @Autowired
    private JudgeThreadPoolManager judgeThreadPoolManager;

    @PostMapping("/judge")
    @JudgePermitAnnotation
    public Boolean judge(@RequestBody JudgeSource judgeSource){
        if(judgeSource == null){
            return null;
        }
        judgeThreadPoolManager.addTask(judgeSource);
        return false;
    }
}
