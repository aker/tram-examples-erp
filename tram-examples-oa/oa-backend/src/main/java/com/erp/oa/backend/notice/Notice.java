package com.erp.oa.backend.notice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private NoticeState state;

    private String title;
    private String context;

    public Notice() {}

    public Notice(String title, String context) {
        this.title = title;
        this.context = context;
        this.state = NoticeState.PENDING;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public NoticeState getState() {
        return state;
    }

    public void setState(NoticeState state) {
        this.state = state;
    }
}