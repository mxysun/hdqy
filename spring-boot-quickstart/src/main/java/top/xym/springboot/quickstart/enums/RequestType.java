package top.xym.springboot.quickstart.enums;
//RequestType，表示不同的请求类型
/*
目标：学习如何使用JDK12 引入的Switch Expressions,实现更简洁和强大的路由逻辑，
并在Spring Boot中使用它来决定不同的服务处理逻辑
 */

/*
1.任务描述：假设你正在开发一个客服系统，
需要根据用户请求的类型（查询、投诉、建议）来路由到不同的处理服务
 */
public enum RequestType {
    QUERY,
    COMPLAINT,
    SUGGESTION
}
