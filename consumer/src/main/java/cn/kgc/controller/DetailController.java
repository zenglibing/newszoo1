package cn.kgc.controller;

import cn.kgc.service.DetailService;
import cn.kgc.vo.Category;
import cn.kgc.vo.Detail;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class DetailController {
    @Resource
    private DetailService detailService;
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
    @RequestMapping("/findCategory.do")
    public List<Category> findCategory(){
        List<Category> category=detailService.findCategory();
        return category;
    }
    @RequestMapping("/find.do")
    public PageInfo<Detail> find(Integer categoryId, String title, Integer pageNo){
        PageInfo<Detail> pageInfo=detailService.find(categoryId,title,pageNo);
        return pageInfo;
    }
    @RequestMapping("/findId.do")
    public HashMap<Object,Object> findId(Integer id){
        Detail detail=detailService.findById(id);
        List<Category> category=detailService.findCategory();
        HashMap<Object,Object>map=new HashMap<Object, Object>();
        map.put("detail",detail);
        map.put("category",category);
        return map;
    }
    @RequestMapping("/update.do")
    public String update(Detail detail){
        detail.setUpdateDate(new Date());
        Integer flag=detailService.update(detail);
        if(flag>0){
            return "1";
        }else {
            return "2";
        }
    }
}
