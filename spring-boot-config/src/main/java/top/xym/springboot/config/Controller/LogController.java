package top.xym.springboot.config.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.config.service.LogService;

/**
 * @author 12862
 */
@RestController
@AllArgsConstructor
public class LogController {
    private final LogService logService;
    @GetMapping("/log")
    public void logMsg() {
        logService.logMessage();
    }
}
