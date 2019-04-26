package com.tugasmobile.diss.tugas02sules;

public class DateParser {
    private String date_yyyy_mm_dd;
    public DateParser (String date) {
        this.date_yyyy_mm_dd = date;
    }

    public String dateHumanist () {
        String[] arr = date_yyyy_mm_dd.split("-");
        String result;
        String month = "";
        if (arr.length < 3) {
            return null;
        }
        switch (arr[1]) {
            case "01" :
                month = "January";
                break;
            case "02" :
                month = "February";
                break;
            case "03" :
                month = "March";
                break;
            case "04" :
                month = "April";
                break;
            case "05" :
                month = "May";
                break;
            case "06" :
                month = "June";
                break;
            case "07" :
                month = "July";
                break;
            case "08" :
                month = "August";
                break;
            case "09" :
                month = "September";
                break;
            case "10" :
                month = "October";
                break;
            case "11" :
                month = "November";
                break;
            case "12" :
                month = "December";
                break;
        }
        return month+" "+arr[2]+", "+arr[0];
    }
}
