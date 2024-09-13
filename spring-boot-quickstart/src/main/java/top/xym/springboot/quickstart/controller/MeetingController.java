package top.xym.springboot.quickstart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.quickstart.entity.Meeting;
import top.xym.springboot.quickstart.service.MeetingService;


@RestController
@RequestMapping("/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    /**
     * 检查会议室是否在指定的时间段内可用，并根据可用性预定会议。
     *
     * @param  meeting 通过请求体传入的会议对象，包含会议的日期和时间信息。
     * @return 如果会议室可用，返回HTTP状态码 200 （ok） 和成功消息；
     * 如果不可用，返回HTTP状态码 409 （Conflict） 和失败消息。
     */
    @PostMapping("/check")
    public ResponseEntity<String> checkAvailability(@RequestBody Meeting meeting) {
        if (meetingService.isRoomAvailable(meeting)) {
            meetingService.addMeeting(meeting);
            return ResponseEntity.ok("会议室可用，会议已预定！");
        } else {
            return ResponseEntity.status(409).body("会议室不可用！");
        }
    }
}
