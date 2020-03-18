package com.robot.dao;


import com.robot.entities.AnswerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerRecordTemplate {
    @Autowired
    MongoTemplate mongoTemplate;

    //返回作答记录
    public List<AnswerRecord> getAllAnswerRecord(){
        return mongoTemplate.findAll(AnswerRecord.class);
    }

    //记录数据
    public void saveAnswerRecord(AnswerRecord answerRecord){
        mongoTemplate.save(answerRecord);
    }




}
