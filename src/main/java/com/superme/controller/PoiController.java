package com.superme.controller;

import com.superme.service.PoiService;
import com.superme.utils.PageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * description:<POI报表输出控制层>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/8/25 11:50
 */
@RestController
@RequestMapping("/poi")
public class PoiController {

    private static Logger logger = LoggerFactory.getLogger(PoiController.class);

    @Autowired
    private PoiService poiService;


    @RequestMapping(value = "/getExcell/{pageNum}/{pageSize}")
    public void getExcell(@PathVariable int pageNum, @PathVariable int pageSize, HttpServletResponse response) {
        logger.info(pageNum + "---" + pageSize);
        poiService.getExcell(new PageItem(pageNum, pageSize), response);
        logger.info("Excell表格已经生成完毕!");
    }

    @RequestMapping(value = "/easyExcell/{pageNum}/{pageSize}")
    public void getEasyExcell(@PathVariable int pageNum, @PathVariable int pageSize, HttpServletResponse response) {
        logger.info(pageNum + "---" + pageSize);
        poiService.getEasyExcell(new PageItem(pageNum, pageSize), response);
        logger.info("阿里巴巴表格已经打印完毕");

    }

    @RequestMapping(value = "/creat")
    public void creatData() {
        poiService.creatPoiUser();
    }

}
