package com.robot.controller;

import com.robot.entities.AnswerRecord;
import com.robot.service.AnswerRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AnswerRecordController {
    @Autowired
    AnswerRecordService answerRecordService;


    @GetMapping("/answerRecords")
    public List<AnswerRecord> getAllAnswerRecord(){
        return answerRecordService.getAllAnswerRecord();
    }


    @PostMapping("/answerRecord")
    public String saveAnswerRecord(@RequestBody Map<String, Object> map){
        answerRecordService.saveAnswerRecord(map);
        return "success";
    }



}
