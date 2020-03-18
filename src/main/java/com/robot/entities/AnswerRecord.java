package com.robot.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "answerRecord")
public class AnswerRecord {
    private ObjectId id;
    private String educationBackground; //学历
    private Integer age; //年龄
    private String region; //地区
    private List<Integer> choiceList; //选择的答案

    public AnswerRecord(){
        choiceList = new ArrayList<Integer>();
        id = new ObjectId();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Integer> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Integer> choiceList) {
        this.choiceList = choiceList;
    }
}
