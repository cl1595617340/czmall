package com.bdqn.springboot.entity.queryList;

public class QueryList {

    private String laterNumcameras;
    private String cell;
    private String cpunum;
    private String screen;
    private String tab;

    private Integer startslider;
    private Integer endslider;


    private Integer statrPage;
    private Integer endPage;


    public Integer getStatrPage() {
        return statrPage;
    }

    public void setStatrPage(Integer statrPage) {
        this.statrPage = statrPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getStartslider() {
        return startslider;
    }

    public void setStartslider(Integer startslider) {
        this.startslider = startslider;
    }

    public Integer getEndslider() {
        return endslider;
    }

    public void setEndslider(Integer endslider) {
        this.endslider = endslider;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getCpunum() {
        return cpunum;
    }

    public void setCpunum(String cpunum) {
        this.cpunum = cpunum;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getLaterNumcameras() {
        return laterNumcameras;
    }

    public void setLaterNumcameras(String laterNumcameras) {
        this.laterNumcameras = laterNumcameras;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public QueryList() {
    }

    public QueryList(String laterNumcameras, String cell, String cpunum, String screen, String tab, Integer startslider, Integer endslider) {
        this.laterNumcameras = laterNumcameras;
        this.cell = cell;
        this.cpunum = cpunum;
        this.screen = screen;
        this.tab = tab;
        this.startslider = startslider;
        this.endslider = endslider;
    }
}
