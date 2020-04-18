package com.robot.demo;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;
import com.robot.dao.QuestionTemplate;
import com.robot.entities.Question;
import com.robot.service.AnswerRecordService;
import com.robot.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;

import java.nio.file.Paths;
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
        WordDictionary.getInstance().init(Paths.get("conf"));
        System.out.println(Paths.get("conf"));
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String[] sentences =
                new String[] {
                        "深圳市长隆水上世界欢迎你"};

        for (String sentence : sentences) {
            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH).toString());
        }
    }

}
