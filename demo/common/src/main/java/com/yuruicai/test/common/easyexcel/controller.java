package com.yuruicai.test.common.easyexcel;
/**
 * @Description:
 * @Author: yrc
 * @CreateDate: 2019/5/18 13:06
 * @UpdateDate: 2019/5/18 13:06
 */

import com.yuruicai.test.common.easyexcel.model.WriteModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Y
 * @create 2019-05-18 13:06
 * @desc
 **/
@RequestMapping("v1/execl")
@Controller
public class controller {
    @RequestMapping("download")
    public void download(HttpServletResponse response) throws Exception {
        ExcelTests excelTests = new ExcelTests();
        excelTests.writeExcel1(response , "", "test123", excelTests.createModelList() , WriteModel.class);
    }
}
