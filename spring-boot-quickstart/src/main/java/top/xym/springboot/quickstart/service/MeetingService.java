package top.xym.springboot.quickstart.service;
//服务类  在其中使用Java时间API检查会议时间的重叠

import org.springframework.stereotype.Service;
import top.xym.springboot.quickstart.entity.Meeting;

import java.util.ArrayList;
import java.util.List;


@Service
public class MeetingService {

    private final List<Meeting> meetings = new ArrayList<>();

    /**
     * 检查会议室是否可用于新的会议（newMeeting）
     *
     * @param newMeeting 要检查的新会议对象。
     * @return 如果会议室在新会议的时间段内可用，则返回true；否则返回false。
     */
    public boolean isRoomAvailable(Meeting newMeeting) {
        //使用Java Stream API 来检查会议列表中是否有与新会议重叠的会议
        return meetings.stream()
                //如果存在任何与新会议时间重叠的现有会议，返回false
                .noneMatch(existingMeeting -> existingMeeting.isOverlapping(newMeeting));
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }
}
