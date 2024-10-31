package top.xym.springboot.task.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {

    @Value("${gaode.api.key}")
    private String gaodeApiKey;

    private final JavaMailSender javaMailSender;

    public WeatherService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Scheduled(fixedRate = 60000) // 每分钟执行一次
    public void fetchWeatherAndSendEmail() {
        String city = "南京";
        String url = "https://restapi.amap.com/v3/weather/weatherinfo?extensions=base&key=" + gaodeApiKey + "&city=" + city;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                // 解析 JSON 响应获取天气信息
                String weatherData = response.body();
                // 提取需要的天气信息，假设天气信息在 "weather" 字段中
                String weatherInfo = extractWeatherInfo(weatherData);
                // 发送邮件
                sendEmail(weatherInfo);
            } else {
                System.out.println("获取天气数据失败，状态码：" + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String extractWeatherInfo(String weatherData) {
        // 这里根据高德地图天气接口的 JSON 格式进行解析
        // 假设天气信息在特定的 JSON 路径下，实际中需要根据接口文档进行调整
        return "解析后的天气信息";
    }

    private void sendEmail(String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("1286280961@qq.com");
        mailMessage.setSubject("天气信息");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }
}