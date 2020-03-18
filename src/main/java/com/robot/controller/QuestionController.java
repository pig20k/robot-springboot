package com.robot.controller;

import com.robot.dao.QuestionTemplate;
import com.robot.entities.Question;
import com.robot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;



    /*
    添加问题
     */
    @PostMapping("/question")
    public void addQuestion(@RequestBody Map<String, Object> map){
        questionService.addQuestion(map);
    }

    /*
    获取所有问题
     */
    @GetMapping("/questions")
    public List<Question> findAll(){
        return questionService.getAllQuestion();
    }


    /*
    提交答案并返回分析
     */
    @ResponseBody
    @PostMapping("/commit")
    public void getAnalysisResult(@RequestBody Map<String, Object> map){
        questionService.commitAnswer(map);
    }

}
