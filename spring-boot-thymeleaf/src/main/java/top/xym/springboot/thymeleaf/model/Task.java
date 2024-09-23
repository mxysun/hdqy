package top.xym.springboot.thymeleaf.model;
//该类表示每个待办事项
/**
 * @author 12862
 */
public class Task {
    private Long id;
    private String description;
    private Boolean completed;

    public Task(Long id, String description) {
        this.id = id;
        this.description =description;
        //默认未完成
        this.completed = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }



}
