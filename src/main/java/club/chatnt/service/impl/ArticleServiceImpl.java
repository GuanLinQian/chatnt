package club.chatnt.service.impl;

import club.chatnt.entity.Article;
import club.chatnt.mapper.ArticleMapper;
import club.chatnt.service.ArticleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lq
 * @since 2020-01-30
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Override
    public Page getArticles_User(Page page) {
        return page.setRecords(this.baseMapper.getArticles_User(page));
    }

    @Override
    public List<Article> getArticles_UserTop() {
        return this.baseMapper.getArticles_UserTop();
    }
}
