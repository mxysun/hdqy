package top.xym.springboot.config.service;

import cn.hutool.extra.qrcode.QrCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Slf4j
@Component
public class QrCodeService {

    @Value("${custom.qrcode.content}")
    private String qrContent;

    public void generateQrCode() {
        if (qrContent == null || qrContent.isEmpty()) {
            log.warn("二维码内容为空，无法生成二维码。");
            return;
        }
        QrCodeUtil.generate(qrContent, 300, 300, new File("qrcode.png"));
        log.info("⼆维码⽣成成功！");
    }
}
