package com.yoj.judge_server.model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteMessage {

	private String error;

	private String stdout;

}