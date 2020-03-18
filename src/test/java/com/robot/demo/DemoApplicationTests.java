package com.robot.demo;

import com.robot.dao.QuestionTemplate;
import com.robot.entities.Question;
import com.robot.service.AnswerRecordService;
import com.robot.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;
import java.util.HashMap;


@SpringBootTest
class DemoApplicationTests {

    @Autowired
    AnswerRecordService answerRecordService;

    @Autowired
    QuestionService questionService;


    @Autowired
    QuestionTemplate questionTemplate;

    @Test
    void contextLoads() {
//        Question question = new Question();
//        question.setId("2");
//        question.setTitle("张三想要杀了你，你是否反击？");
//        question.setChoices(Arrays.asList("为了自卫，要反击", "张三是主人，不能反击"));
//        questionTemplate.addQuestion(question);
    }

}
