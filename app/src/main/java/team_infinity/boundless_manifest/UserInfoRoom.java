package team_infinity.boundless_manifest;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Vallyath on 2018-01-26.
 */

@Entity(tableName = "userInfo")
public class UserInfoRoom {

    //session id that is autogenerated
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private int qsAnswered;

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String corrAns; //correctAnswer

    //attributes to the question, and how many they currently have
    private int thinkingAtt;
    private int understandAtt;
    private int knowledgeAtt;

    // getters and setters for all the attributes
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getQsAnswered(){
        return qsAnswered;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer1(){
        return answer1;
    }

    public String getAnswer2(){
        return answer1;
    }

    public String getAnswer3(){
        return answer1;
    }

    public String getAnswer4(){
        return answer1;
    }

    public int getThinkingAtt(){
        return thinkingAtt;
    }

    public int getUnderstandAtt(){
        return understandAtt;
    }

    public int getKnowledgeAtt() {
        return knowledgeAtt;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setQsAnswered(int numAnswered){
        qsAnswered = numAnswered;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setAnswer1(String answer){
        this.answer1 = answer;
    }

    public void setAnswer2(String answer){
        this.answer2 = answer;
    }

    public void setAnswer3(String answer){
        this.answer3 = answer;
    }
    public void setAnswer4(String answer){
        this.answer4 = answer;
    }

    public void setThinkingAtt(int numOfAtts){
        this.thinkingAtt = numOfAtts;
    }

    public void setUnderstandAtt(int numOfAtts){
        this.understandAtt = numOfAtts;
    }

    public void setKnowledgeAtt(int numOfAtts) {
        this.knowledgeAtt = numOfAtts;
    }

}
