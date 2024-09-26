package top.xym.springboot.config.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.config.service.ConfigBackupService;

/**
 * @author 12862
 */
@RestController
@AllArgsConstructor
public class ConfigBackupController {
    private final ConfigBackupService configBackupService;
    @GetMapping("/backup")
    public void backupConfig() {
        configBackupService.backupConfigFile();
    }
}