package com.robot.service;

import com.robot.dao.AnswerRecordTemplate;
import com.robot.entities.AnswerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AnswerRecordService {

    @Autowired
    AnswerRecordTemplate answerRecordTemplate;

    public List<AnswerRecord> getAllAnswerRecord(){
        return answerRecordTemplate.getAllAnswerRecord();
    }

    @Async//设置同步
    public void saveAnswerRecord(Map<String, Object> map){
        AnswerRecord answerRecord = new AnswerRecord();
        String eduCationBackground = (String)map.get("eduCationBackground");
        Integer age = (Integer)map.get("age");
        String region = (String)map.get("region");
        List<Integer> choiceList = (ArrayList<Integer>)map.get("choiceList");
        answerRecord.setAge(age);
        answerRecord.setChoiceList(choiceList);
        answerRecord.setEducationBackground(eduCationBackground);
        answerRecord.setRegion(region);
        answerRecordTemplate.saveAnswerRecord(answerRecord);
    }

}
