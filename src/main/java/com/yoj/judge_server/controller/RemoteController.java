package com.yoj.judge_server.controller;

import com.yoj.judge_server.annotation.JudgePermitAnnotation;
import com.yoj.judge_server.model.JudgeSource;
import com.yoj.judge_server.model.Solution;
import com.yoj.judge_server.threads.JudgeThreadPoolManager;
import com.yoj.judge_server.utils.Judger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// not local means development model,which don't have lots of requests.
@Slf4j
@RestController
@ConditionalOnProperty(prefix="judge",name = "local", havingValue = "false")
public class RemoteController {
    @Autowired
    private Judger judger;

    @PostMapping("/judge")
    @JudgePermitAnnotation
    public Solution judge(@RequestBody JudgeSource judgeSource) {
        if(judgeSource == null){
            return null;
        }
        Solution solution = judger.judge(judgeSource);
        return solution;
    }
}
