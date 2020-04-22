package com.lzj.socketservice.entity;

/**
 * Description: 作用描述
 * Author: Lzj
 * CreateDate: 2020/4/22
 */
public class NettyResponseBean {
    /**
     * code : 2
     * msg : 考勤数据
     * data : {"id":111111111}
     */

    public NettyResponseBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        /**
         * campusName : 温江校区
         * cardNo : 1416370708
         * grade : 小四
         * studentName : 李高艺
         * studentNo : 1416370708
         * dateTime:xxxxxx
         */
        private String dateTime;
        private String campusName;
        private String cardNo;
        private String grade;
        private String studentName;
        private String studentNo;

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public String getCampusName() {
            return campusName;
        }

        public void setCampusName(String campusName) {
            this.campusName = campusName;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getStudentNo() {
            return studentNo;
        }

        public void setStudentNo(String studentNo) {
            this.studentNo = studentNo;
        }
    }
}
