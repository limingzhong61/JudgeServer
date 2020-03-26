package com.yoj.judge_server.threads;

import com.alibaba.fastjson.JSON;
import com.yoj.judge_server.utils.Judger;
import com.yoj.judge_server.utils.JudgeInfoUtil;
import com.yoj.judge_server.utils.JudgePermitUtil;
import com.yoj.judge_server.model.JudgeSource;
import com.yoj.judge_server.model.Solution;
import com.yoj.judge_server.utils.HttpUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")//spring 多例
@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class JudgeTask implements Runnable {
    @Autowired
    private Judger judge;
    @Autowired
    private HttpUtil httpUtil;
    @Autowired
    private JudgePermitUtil judgePermitUtil;
    @Autowired
    private JudgeInfoUtil judgeInfoUtil;

    private JudgeSource judgeSource;

    public JudgeTask(JudgeSource judgeSource) {
        this.judgeSource = judgeSource;
    }

    @Override
    public void run() {
        //业务操作
        System.out.println("多线程已经处理任务插入系统，Solution号：" + judgeSource.getSolutionId());
        Solution solution = judge.judge(judgeSource);
            String jsonString = JSON.toJSONString(solution);
            StringEntity entity = new StringEntity(jsonString, "UTF-8");
            ArrayList<BasicHeader> basicHeaders = new ArrayList<>();
            basicHeaders.add(new BasicHeader("Content-Type", "application/json;charset=utf8"));
            basicHeaders.add(judgePermitUtil.getJudgePermitHeader());
            log.info("backendUrl:{}",judgeInfoUtil.getBackendUrl());
            log.info("entity:{}",entity);
            log.info("basicHeaders:{}",basicHeaders);
            httpUtil.doPostWithRequestBody(judgeInfoUtil.getBackendUrl(),
                    entity,basicHeaders);
    }
}