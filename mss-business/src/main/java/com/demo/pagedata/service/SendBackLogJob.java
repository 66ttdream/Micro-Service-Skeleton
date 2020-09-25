package com.demo.pagedata.service;

import com.demo.chat.controller.ChatController;
import com.demo.task.service.TaskGroupService;

import javax.annotation.Resource;

public class SendBackLogJob {
    @Resource
    private ChatController chatController;
    @Resource
    private TaskGroupService taskGroupService;



}
