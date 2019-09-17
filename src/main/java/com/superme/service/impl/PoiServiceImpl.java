package com.superme.service.impl;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.superme.bean.PoiUser;
import com.superme.constent.PoiConstent;
import com.superme.mapper.PoiMapper;
import com.superme.service.PoiService;
import com.superme.utils.PageItem;
import com.superme.utils.PoiUtil;
import com.superme.utils.WriteExcelDataDelegated;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * description:<POI业务层实现>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/9/3 9:36
 */
@Service
public class PoiServiceImpl implements PoiService {

    @Resource
    private PoiMapper poiMapper;

    private static Logger logger = LoggerFactory.getLogger(PoiServiceImpl.class);


    @Override
    public void creatPoiUser() {
        for (int i = 0; i < PoiConstent.NEED_CREAT_NUMS; i++) {
            PoiUser poiUser = new PoiUser();
            poiUser.setUserId(i + 1);
            poiUser.setUserName("测试" + i);
            String uuid = UUID.randomUUID().toString();
            poiUser.setLine1(uuid);
            poiUser.setLine2(uuid);
            poiUser.setLine3(uuid);
            poiUser.setLine4(uuid);
            poiUser.setLine5(uuid);
            poiUser.setLine6(uuid);
            poiUser.setLine7(uuid);
            poiUser.setLine8(uuid);
            try {
                poiMapper.creatPoiUser(poiUser);
            } catch (Exception e) {
                logger.info("插入数据异常, message:{}", e.getMessage(), e);
            }


        }
    }

    @Override
    public void getExcell(PageItem pageItem, HttpServletResponse response) {
        try {
            // 获取数据行数
            long count = poiMapper.getCount();
            // 定义文件名称
            String fileName = "批量导出十万数据";
            // 标题
            String[] titles = {"用户Id", "用户名称", "参数1", "参数2", "参数3", "参数4", "参数5", "参数6", "参数7", "参数8"};
            // 开始导出
            PoiUtil.exportExcelToWebsite(response, count, fileName, titles, new WriteExcelDataDelegated() {
                @Override
                public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {

                    List<PoiUser> poiUsers = poiMapper.getPoiUsers(pageItem.getPageStart(), pageItem.getPageSize());
                    if (CollectionUtils.isNotEmpty(poiUsers)) {
                        for (int i = startRowCount; i <= endRowCount; i++) {
                            SXSSFRow eachDataRow = eachSheet.createRow(i);
                            if ((i - startRowCount) < poiUsers.size()) {
                                PoiUser poiUser = poiUsers.get(i - startRowCount);
                                // 在行元素上创建一个列, 并为其赋值Vector
                                eachDataRow.createCell(0).setCellValue(poiUser.getUserId());
                                eachDataRow.createCell(1).setCellValue(poiUser.getUserName());
                                eachDataRow.createCell(2).setCellValue(poiUser.getLine1());
                                eachDataRow.createCell(3).setCellValue(poiUser.getLine2());
                                eachDataRow.createCell(4).setCellValue(poiUser.getLine3());
                                eachDataRow.createCell(5).setCellValue(poiUser.getLine4());
                                eachDataRow.createCell(6).setCellValue(poiUser.getLine5());
                                eachDataRow.createCell(7).setCellValue(poiUser.getLine6());
                                eachDataRow.createCell(8).setCellValue(poiUser.getLine7());
                                eachDataRow.createCell(9).setCellValue(poiUser.getLine8());
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            logger.info("数据导出出问题了, message: {}", e.getMessage(), e);
        }

    }

    @Override
    public void getEasyExcell(PageItem pageItem, HttpServletResponse response) {
        ServletOutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();
            // 创建输出文件
            ExcelWriter excelWriter = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX);

            // 文件名
            String fileName = new String("SystemExcell".getBytes(), "UTF-8");

            // sheet名
            Sheet sheet = new Sheet(0, 1);
            sheet.setSheetName("SystemSheet1");
            // table
            Table table = new Table(1);
            // 设置表头
            List<List<String>> titles = new ArrayList<>();
            titles.add(Arrays.asList("用户Id"));
            titles.add(Arrays.asList("用户名称"));
            titles.add(Arrays.asList("备注1"));
            titles.add(Arrays.asList("备注2"));
            titles.add(Arrays.asList("备注3"));
            titles.add(Arrays.asList("备注4"));
            titles.add(Arrays.asList("备注5"));
            titles.add(Arrays.asList("备注6"));
            titles.add(Arrays.asList("备注7"));
            titles.add(Arrays.asList("备注8"));

            table.setHead(titles);

            // 表格内容
            List<PoiUser> poiUsers = poiMapper.getPoiUsers(pageItem.getPageStart(), pageItem.getPageSize());
            List<List<String>> dataList = new ArrayList<>();

            // 如果查询到的数据不为空, 就将其写入Excel
            if (CollectionUtils.isNotEmpty(poiUsers)) {
                for (PoiUser poiUser : poiUsers) {
                    dataList.add(Arrays.asList(String.valueOf(poiUser.getUserId()),
                            poiUser.getUserName(),
                            poiUser.getLine1(),
                            poiUser.getLine2(),
                            poiUser.getLine3(),
                            poiUser.getLine4(),
                            poiUser.getLine5(),
                            poiUser.getLine6(),
                            poiUser.getLine7(),
                            poiUser.getLine8()));
                }
                excelWriter.write0(dataList, sheet, table);
            }

            // 下载EXCEL
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            excelWriter.finish();
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
