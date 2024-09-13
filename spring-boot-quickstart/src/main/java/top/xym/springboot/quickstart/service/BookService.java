package top.xym.springboot.quickstart.service;
//服务类 BookService ，返回书籍DTO列表
import org.springframework.stereotype.Service;
import top.xym.springboot.quickstart.dto.BookDTO;

import java.util.List;

@Service
public class BookService {

    public List<BookDTO> getAllBooks() {
        return List.of(
                new BookDTO(1L,"Java Programming","Alice",29.99),
                new BookDTO(2L, "Spring Boot in Action", "Bob", 34.99)
        );
    }

}
