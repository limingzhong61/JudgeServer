package com.yoj.judge_server.model.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description: 除此配置外，还需在修改judge中指定ExecutorUtil的注入类
 * @Param:
 * @return:
 * @Author: lmz
 * @Date: 2019/10/20
 */
@Component
@ConfigurationProperties(prefix = "judge")
@PropertySource("classpath:judge.properties")
@Setter
@Getter
@ToString
public class JudgeProperties {
//保存题目的路径，必须存在，path必须有‘/’结尾,不能保存在/tmp目录下，重启会被删除文件
    private String judgeScriptPath;
    //保存题目的路径，必须存在，path必须有‘/’结尾,不能保存在/tmp目录下，重启会被删除文件
    private String problemFilePath;
    //solution暂存路径
    private String solutionFilePath;

    private String model;
}
