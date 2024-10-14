package top.xym.springboot.database.service;

import top.xym.springboot.database.entity.Article;

import java.util.List;

/**
 * @author 12862
 */
// 这段代码定义了一个名为ArticleService的接口，用于处理与文章（Article）相关的业务逻辑.
public interface ArticleService {

    // 这个方法用于保存一篇文章到数据库或其他存储介质中。
    // 输入参数是一个Article对象，代表要保存的文章。
    // 返回值也是一个Article对象，可能是保存后的文章对象，包含了可能被数据库生成的一些属性，如自增长的 ID。
    Article saveArticle(Article article);

    // 此方法用于根据文章的 ID 删除一篇文章。
    // 输入参数是一个表示文章 ID 的Long类型值。
    // 没有返回值，因为该方法的目的只是执行删除操作。
    void deleteArticle(Long id);

    // 用于更新一篇已存在的文章。
    // 输入参数是一个包含更新后信息的Article对象。
    // 没有返回值，执行更新操作后，数据库中的对应文章数据将被更新为传入的文章对象的状态。
    void updateArticle(Article article);

    // 根据文章的 ID 获取一篇文章。
    // 输入参数是文章的 ID。
    // 返回值是一个Article对象，代表找到的文章，如果没有找到对应 ID 的文章，可能返回null。
    Article getArticle(Long id);

    // 用于获取所有的文章。
    // 没有输入参数。
    // 返回值是一个包含所有文章的List集合，每个元素都是一个Article对象。
    List<Article> getAll();
}
