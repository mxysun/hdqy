package top.xym.springboot.quickstart.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Meeting {
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    // Controllers, getters, and setters

    /**
     * 判断当前会议（this）与另一个会议（other）是否在同一天且时间上有重叠
     *
     * @param other 要检查的另一个会议对象
     * @return 如果两个会议在同一天且时间上有重叠，返回true;否则返回false
     */
    public boolean isOverlapping(Meeting other) {
        //检查两个会议是否在同一天
        return this.date.equals(other.date) &&
                //检查当前会议的开始时间是否在其他会议的结束时间之前
                //且当前会议的结束时间是否在其他会议的开始时间之后
                (this.startTime.isBefore(other.endTime) &&
                        this.endTime.isAfter(other.startTime));
    }
}
