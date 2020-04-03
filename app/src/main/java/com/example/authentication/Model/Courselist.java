package com.example.authentication.Model;

public class Courselist {

    private  String cname;
    private String cid;
    private String abbr;


    public  Courselist()
    {

    }

    public Courselist(String cname, String cid, String abbr) {
        this.cname = cname;
        this.cid = cid;
        this.abbr = abbr;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    //    public  Courselist(String cname,String cid,String abbr)
//    {
//
//    }






}
