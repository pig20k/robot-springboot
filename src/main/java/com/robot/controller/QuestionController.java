package com.robot.controller;

import com.robot.dao.QuestionTemplate;
import com.robot.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {
    @Autowired
    QuestionTemplate questionTemplate;

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        System.out.println("hello----");
        return "hello";
    }

    /*
    添加问题
     */
    @ResponseBody
    @PostMapping("/addQuestion")
    public void addQuestion(@RequestBody Map<String, Object> map){
        List<String> choices = (List<String>)map.get("choices");
        String id = (String)map.get("id");
        String title = (String)map.get("title");
        Question question = new Question();
        question.setChoices(choices);
        question.setId(id);
        question.setTitle(title);
        questionTemplate.addQuestion(question);
    }

    /*
    获取所有问题
     */
    @ResponseBody
    @GetMapping("/getAll")
    public List<Question> findAll(){
        return questionTemplate.findAll();
    }

    /*
    提交答案并返回分析
     */
    @ResponseBody
    @PostMapping("/commit")
    public String getAnalysisResult(@RequestBody Map<String, Object> map){

        //传的参数 包括很多道题目的id 以及 答案
        List<String> choiceList = (List<String>)map.get("choiceList");
        List<String> idList = (List<String>)map.get("idList");

        //把每个问题的答案都记录起来，方便以后进行分析
        for(int i = 0;i < choiceList.size();i++){
           questionTemplate.addResponse(idList.get(i), choiceList.get(i));
        }


        //下面是算法进行结果分析
        String result = " 123 ";
        return result;
    }

}
