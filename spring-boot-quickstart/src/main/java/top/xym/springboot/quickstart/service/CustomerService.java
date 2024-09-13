package top.xym.springboot.quickstart.service;
//服务类 ，使用Switch Expressions处理请求路由
import org.springframework.stereotype.Service;
import top.xym.springboot.quickstart.enums.RequestType;

@Service
public class CustomerService {

        public String handleRequest(RequestType requestType) {
            return switch (requestType) {
                case QUERY -> handleQuery();
                case COMPLAINT -> handleComplaint();
                case SUGGESTION -> handleSuggestion();
            };
        }

        private String handleQuery() {
            return "Handling user query...";
        }

        private String handleComplaint() {
            return "Handling user complaint";
        }

        private String handleSuggestion() {
            return "Handling user suggestion...";
        }


}
