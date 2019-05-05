package com.lerh.service.impl;/*
 *
 *          ┌─┐       ┌─┐
 *       ┌──┘ ┴───────┘ ┴──┐
 *       │                 │
 *       │       ───       │
 *       │  ─┬┘       └┬─  │
 *       │                 │
 *       │       ─┴─       │
 *       │                 │
 *       └───┐         ┌───┘
 *           │         │
 *           │         │
 *           │         │
 *           │         └──────────────┐
 *           │                        │
 *           │                        ├─┐
 *           │                        ┌─┘
 *           │                        │
 *           └─┐  ┐  ┌───────┬──┐  ┌──┘
 *             │ ─┤ ─┤       │ ─┤ ─┤
 *             └──┴──┘       └──┴──┘
 *                 神兽保佑
 *                 代码无BUG!
 * @Title: FileServiceImpl
 * @PackageNmae: com.lerh.service.impl
 * @Description:
 * @author Lerh
 * @date 2:06 PM 2019/5/5
 *//*
 *
 *          ┌─┐       ┌─┐
 *       ┌──┘ ┴───────┘ ┴──┐
 *       │                 │
 *       │       ───       │
 *       │  ─┬┘       └┬─  │
 *       │                 │
 *       │       ─┴─       │
 *       │                 │
 *       └───┐         ┌───┘
 *           │         │
 *           │         │
 *           │         │
 *           │         └──────────────┐
 *           │                        │
 *           │                        ├─┐
 *           │                        ┌─┘
 *           │                        │
 *           └─┐  ┐  ┌───────┬──┐  ┌──┘
 *             │ ─┤ ─┤       │ ─┤ ─┤
 *             └──┴──┘       └──┴──┘
 *                 神兽保佑
 *                 代码无BUG!
 * @Title: FileServiceImpl
 * @PackageNmae: com.lerh.service.impl
 * @Description:
 * @author Lerh
 * @date 2:06 PM 2019/5/5
 */

import com.lerh.dao.FilemanageMapper;
import com.lerh.entity.AjaxEntity;
import com.lerh.entity.Filemanage;
import com.lerh.service.FileService;
import com.lerh.util.IpUtil;
import com.lerh.util.PropertiesUtil;
import com.lerh.util.UuidUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FilemanageMapper filemanageMapper;
    private static Logger logger=Logger.getLogger("fileService");

    @Override
    public AjaxEntity save(HttpServletRequest request) {

        AjaxEntity ajaxEntity=new AjaxEntity();

        Properties pro=PropertiesUtil.getproperties("/lerhConfig.properties");
        String filepath=pro.getProperty("fileRoute");
        // 创建list集合，用于接收上传文件的路径
        List<String> filePathList = new ArrayList<String>();
//        检验文件夹是否存在，不存在则创建该文件夹
        File file=new File(filepath);
        if(!file.exists()&&!file.isDirectory()){
           logger.info("目录或文件不存在！");
           file.mkdir();
        }
//        文件上传
        try {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            //解决上传文件名的中文乱码
            fileUpload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if(!ServletFileUpload.isMultipartContent(request)){
                //按照传统方式获取数据
               logger.info("上传文件类型不为表单类型");
            }
            //4、 转换request，解析出request中的文件
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            // 获取文件map集合
            Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

            List<FileItem> list = fileUpload.parseRequest(request);
            String fileName="";
            for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {

                // 获取单个文件
                MultipartFile mf = entity.getValue();

                // 获得原始文件名
                fileName = mf.getOriginalFilename();

                // 截取文件类型; 这里可以根据文件类型进行判断
                String fileType = fileName.substring(fileName.lastIndexOf('.'));

                try {
                    // 截取上传的文件名称
                    String newFileName = UuidUtil.getUuid();

                    // 拼接上传文件位置
                    String newfilePath = filepath + File.separatorChar + newFileName + fileType;

                    logger.info("拼接好的文件路径地址------------->>>>>>>>" + newfilePath);



                    // 创建文件存放路径实例
                    File dest = new File(filepath);

                    // 判断文件夹不存在就创建
                    if (!dest.exists()) {
                        dest.mkdirs();
                    }
                    // 创建文件实例
                    File uploadFile = new File(newfilePath);
                    // 判断文件已经存在，则删除该文件
                    if (uploadFile.exists()) {
                        uploadFile.delete();
                    }
                    logger.info("start upload file-------------->>>>>>> " + fileName);
                    // 利于spring中的FileCopyUtils.copy()将文件复制
                    FileCopyUtils.copy(mf.getBytes(), uploadFile);

//文件上传完毕

//                    存入文件信息到数据库
                    Filemanage filemanage=new Filemanage();
                    filemanage.setId(UuidUtil.getUuid());
                    filemanage.setName(fileName);
                    filemanage.setSavaname(newFileName);
                    filemanage.setCreatetime(new Date());
                    filemanage.setFileroute(newfilePath);
                    filemanage.setUploadip(IpUtil.getIpAddress(request));
                    filemanageMapper.insert(filemanage);
                    ajaxEntity.setStatus("true");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    logger.info("upload failed. filename: " + fileName+"---->>>error message ----->>>>> "+ e.getMessage());
                    ajaxEntity.setStatus("false");
                }
            }
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.info("文件上传失败");
            ajaxEntity.setStatus("false");
        }
        return ajaxEntity;
    }
}
