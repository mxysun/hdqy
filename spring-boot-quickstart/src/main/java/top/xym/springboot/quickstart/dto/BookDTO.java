package top.xym.springboot.quickstart.dto;
//定义一个书籍记录类BookDTO
public record BookDTO(Long id, String title, String author, double price) {
    public BookDTO {
        if(price < 0) {
            throw new IllegalArgumentException("Price cannot be nagative");
        }
    }
}
