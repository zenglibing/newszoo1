package cn.kgc.service;

import cn.kgc.mapper.DetailMapper;
import cn.kgc.vo.Category;
import cn.kgc.vo.Detail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class DetailServiceImpl implements DetailService {
    @Resource
    private DetailMapper detailMapper;
    @Override
    public PageInfo<Detail> find(Integer categoryId, String title, Integer pageNo) {
        PageHelper.startPage(pageNo,2);
        List<Detail>list=detailMapper.find(categoryId, title);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public Detail findById(Integer id) {
        return detailMapper.findById(id);
    }

    @Override
    public Integer update(Detail detail) {
        return detailMapper.update(detail);
    }

    @Override
    public List<Category> findCategory() {
        return detailMapper.findCategory();
    }
}
