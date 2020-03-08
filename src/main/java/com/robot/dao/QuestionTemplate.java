package com.robot.dao;

import com.robot.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionTemplate {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Question> findAll(){
        return mongoTemplate.findAll(Question.class);
    }

    /*
    对某个问题添加回答
     */
    public void addResponse(String id, String choice){
        Question question = findQuestionById(id);//问题的id
        question.addResponse(choice);
        mongoTemplate.save(question);
    }

    public Question findQuestionById(String id){
        Query query = Query.query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Question.class);
    }

    //添加问题
    public void addQuestion(Question question){
        mongoTemplate.save(question);
    }

}
