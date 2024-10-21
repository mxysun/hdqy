package top.xym.springboot.wenda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12862
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "user")
public class User {
    private Integer userId;
    private String account;
    private String password;
    private String userName;
    private String avatar;
    // 路径链接

    // 一方中声明多方
//    private List<Articles> articles;
//    private List<Comments> comments;
//    private List<Likes> likes;
//    private List<Collections> collects;
}
