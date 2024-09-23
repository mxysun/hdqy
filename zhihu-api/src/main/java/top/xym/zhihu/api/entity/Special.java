package top.xym.zhihu.api.entity;


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
public class Special {
    private String id;
    private String title;
    private String banner;
    private String introduction;
    private String isFollowing;
    private Integer followersCount;
    private Integer viewCount;
    private String updated;


//    public String getUpdate() {
//        return updated;
//    }
//
//    public void setUpdate(String updated) {
//        this.updated = updated;
//    }

}
