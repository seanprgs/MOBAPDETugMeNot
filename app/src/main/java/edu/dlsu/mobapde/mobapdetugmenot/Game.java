package edu.dlsu.mobapde.mobapdetugmenot;

/**
 * Created by Sean Paragas on 12/14/2017.
 */

public class Game
{
    public static final String TABLE_NAME = "game";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DIFFICULTY = "difficulty";
    public static final String COLUMN_TIMELEFT = "timeLeft";
    public static final String COLUMN_RESULT = "result";

    private long id;
    private String difficulty;
    private String time;
    private String result;

    public Game(){}

    public Game(String difficulty, String time, String result) {
        this.difficulty = difficulty;
        this.time = time;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
