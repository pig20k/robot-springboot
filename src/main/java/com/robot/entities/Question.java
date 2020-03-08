package com.robot.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "question")
public class Question {
    private ObjectId objectId;
    private String id;  //问题ID
    private String title; //问题标题
    private List<String> choices; //问题选项
    private List<String> responseList;

    public Question(){
        choices = new ArrayList<>();
        responseList = new ArrayList<>();
    }

    public List<String> getResponseList() {
        return responseList;
    }

    public void addResponse(String choice){
        responseList.add(choice);
    }

    public void setResponseList(List<String> responseList) {
        this.responseList = responseList;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}
