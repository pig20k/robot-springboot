package com.robot.service;

import com.robot.dao.QuestionTemplate;
import com.robot.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionService {
    @Autowired
    QuestionTemplate questionTemplate;

    public List<Question> getAllQuestion(){
        return questionTemplate.findAll();
    }

    public void addQuestion(Map<String, Object> map){
        List<String> choices = (List<String>)map.get("choices");
        String id = (String)map.get("id");
        String title = (String)map.get("title");
        Question question = new Question();
        question.setChoices(choices);
        question.setId(id);
        question.setTitle(title);
        questionTemplate.addQuestion(question);
    }

    public void commitAnswer(Map<String, Object> map){
        //传的参数 包括很多道题目的id 以及 答案
        List<String> choiceList = (List<String>)map.get("choiceList");
        List<String> idList = (List<String>)map.get("idList");

        //把每个问题的答案都记录起来，方便以后进行分析
        for(int i = 0;i < choiceList.size();i++){
            questionTemplate.addResponse(idList.get(i), choiceList.get(i));
        }

    }

}
