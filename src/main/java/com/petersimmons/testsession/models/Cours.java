package com.petersimmons.testsession.models;

public class Cours {

    private static int counter = 0;

    private int id;
    private String title;
    private int nbrCredits;
    private int session;
    private String syllabusFilePath;


    public Cours() {
        this.id = ++counter;
    }

    public Cours(String title, int nbrCredits, int session, String syllabusFilePath) {
        this.id = ++counter;
        this.title = title;
        this.nbrCredits = nbrCredits;
        this.session = session;
        this.syllabusFilePath = syllabusFilePath;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNbrCredits() {
        return nbrCredits;
    }

    public void setNbrCredits(int nbrCredits) {
        this.nbrCredits = nbrCredits;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public String getSyllabusFilePath() {
        return syllabusFilePath;
    }

    public void setSyllabusFilePath(String syllabusFilePath) {
        this.syllabusFilePath = syllabusFilePath;
    }
}
