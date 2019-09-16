package com.superme.demo;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperApplicationTests {

    @Test
    public void readExcel() {

        try {
            // 需要转换的表格的地址
            InputStream inputStream = new FileInputStream("E:/test.xlsx");

            String sqlLanguage = "insert into base_user (login_name, password, role, real_name, mobile, org_name) values \n";

            StringBuilder stringBuilder = new StringBuilder(sqlLanguage);

            EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1), new AnalysisEventListener() {
                @Override
                public void invoke(Object object, AnalysisContext context) {
                    // logger.info("当前行：{} 对应的对象信息为：{}", context.getCurrentRowNum(), object);
                    ArrayList EmpObj = (ArrayList) object;

                    if (EmpObj != null && EmpObj.get(0) != null && EmpObj.get(1) != null && EmpObj.get(2) != null && EmpObj.get(3) != null) {
                        stringBuilder.append("(").append("'" + EmpObj.get(2) + "'").append(", ")
                                .append("'$2a$10$9RfY1.UyXlVaB2.lgbDSXuO33P2tfIsseNuKsk0c.cAFq4iROSwAa'").append(", ")
                                .append("'0'").append(", ").append("'" + EmpObj.get(1) + "'").append(", ")
                                .append("'" + EmpObj.get(2) + "'").append(", ")
                                .append("'" + EmpObj.get(3) + "'").append("),").append("\n");

                    }
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext context) {
                    // 将最后一个逗号替换为分号
                    int i = stringBuilder.toString().lastIndexOf(",");
                    String substring = stringBuilder.toString().substring(0, i);
                    substring = substring + ";";

                    try {
                        // 将输入流关闭
                        inputStream.close();

                        // 然后将字符串写入指定目录的sql文件夹中
                        File file = new File("E:/inset_base_user.sql");
                        PrintWriter printWriter = new PrintWriter(file);
                        printWriter.println(substring);

                        // 将输出流关闭
                        printWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
