package com.lerh.controller.filemanage;/*
 @author LerH
 @DESCRIPTION 
 @create 2019/5/5
*/

import com.lerh.entity.AjaxEntity;
import com.lerh.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
@Api(tags="文件管理")
@RequestMapping(value="fileController")
public class FileController {
    @Autowired
    private FileService fileService;

    /**
     * @Author chengpunan 
     * @Description //TODO 
     * @Date 1:24 PM 2019/5/5
     * @Param []
     * @return com.lerh.entity.AjaxEntity
     */
    @ResponseBody
    @RequestMapping(value="saveFile")
    @ApiOperation(value="文件上传")
    public AjaxEntity saveFile(HttpServletRequest request) {
        AjaxEntity ajaxEntity=new AjaxEntity();
        ajaxEntity= fileService.save(request);
        if("true".equals(ajaxEntity.getStatus())){
//            数据库存入文件信息
            ajaxEntity.setMsg("文件上传成功");
        }

        return  ajaxEntity;
    }
}
