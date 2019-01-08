package cn.kgc.service;

import cn.kgc.vo.Category;
import cn.kgc.vo.Detail;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DetailService {
    public PageInfo<Detail> find(Integer categoryId, String title, Integer pageNo);
    public Detail findById(Integer id);
    public Integer update(Detail detail);
    public List<Category> findCategory();
}
