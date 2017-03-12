package com.sh.ssm.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sh.ssm.taotao.admin.mapper.TbItemMapper;
import com.sh.ssm.taotao.admin.po.TbItem;
import com.sh.ssm.taotao.admin.po.TbItemExample;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MainControllerTest extends TestCase {

    private TbItemMapper tbItemMapper;
    public void setUp() throws Exception {
        super.setUp();
        String path = "classpath:applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        tbItemMapper = (TbItemMapper) applicationContext.getBean(TbItemMapper.class);


    }

    public void testShowIndex() throws Exception {

    }

    public void testPageHelper() throws Exception {
        PageHelper.startPage(1, 30);
        TbItemExample example = new TbItemExample();
        List<TbItem> list = tbItemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        int pageNum = pageInfo.getPageNum();
        long total = pageInfo.getTotal();
        int pages = pageInfo.getPages();
        int size = pageInfo.getSize();
        System.out.println("页数" + pageNum + "总数" + total + "pages" + pages + "size" + size);

    }

}