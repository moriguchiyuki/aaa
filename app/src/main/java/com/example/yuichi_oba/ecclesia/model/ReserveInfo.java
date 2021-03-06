package com.example.yuichi_oba.ecclesia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuichi-Oba on 2017/07/24.
 */

/***
 * 予約情報を管理するクラス
 */
public class ReserveInfo implements Serializable {

    /***
     * Field
     */
    private String re_id;                               // 予約ID
    private String re_overview;                         // 概要
    private String re_purpose;                          // 会議目的名
    private String re_startTime;                        // 開始日時
    private String re_endTime;                          // 終了日時
    private String re_rePerson;                         // ―→ 現状使っていないため、HCP不要
    private List<String> re_member = new ArrayList<>(); // 会議参加者を記録するリスト
    private int re_flg;                                 // 社内（０）社外（１）
    private String re_conference_room;                  // 会議室名
    private String re_marks;                            // 備考？だったけ(笑)

    /***
     * Constractor
     */
    public ReserveInfo() {
    }

    /***
     * Getter/Setter
     */
    public String getRe_id() {
        return re_id;
    }
    public String getRe_overview() {
        return re_overview;
    }
    public String getRe_startTime() {
        return re_startTime;
    }
    public String getRe_endTime() {
        return re_endTime;
    }
    public String getRe_rePerson() {
        return re_rePerson;
    }
    public List<String> getRe_member() {
        return re_member;
    }
    public int getRe_flg() {
        return re_flg;
    }
    public String getRe_conference_room() {
        return re_conference_room;
    }
    public String getRe_marks() {
        return re_marks;
    }
    public String getRe_purpose() {
        return re_purpose;
    }

    public void setRe_id(String re_id) {
        this.re_id = re_id;
    }
    public void setRe_overview(String re_overview) {
        this.re_overview = re_overview;
    }
    public void setRe_startTime(String re_startTime) {
        this.re_startTime = re_startTime;
    }
    public void setRe_endTime(String re_endTime) {
        this.re_endTime = re_endTime;
    }
    public void setRe_rePerson(String re_rePerson) {
        this.re_rePerson = re_rePerson;
    }
    public void setRe_member(List<String> re_member) {
        this.re_member = re_member;
    }
    public void setRe_flg(int re_flg) {
        this.re_flg = re_flg;
    }
    public void setRe_conference_room(String re_conference_room) {
        this.re_conference_room = re_conference_room;
    }
    public void setRe_marks(String re_marks) {
        this.re_marks = re_marks;
    }
    public void setRe_purpose(String re_purpose) {
        this.re_purpose = re_purpose;
    }
}
