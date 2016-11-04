package com.netfinworks.member.gateway.web.controller;


import com.meidusa.fastjson.JSONObject;
import com.netfinworks.member.gateway.enums.BaseField;
import com.netfinworks.member.gateway.model.SignData;
import com.netfinworks.member.gateway.service.RemoteService;
import com.netfinworks.member.gateway.service.SecurityService;
import com.netfinworks.ues.util.UesUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by yinrong on 2016/11/1.
 */
@Controller
public class ImportMemberInformationAction{
    @Resource
    private RemoteService remoteService;
    @Resource
    private SecurityService securityService;

    private static Logger logger = LoggerFactory.getLogger(ImportMemberInformationAction.class);
    @RequestMapping(value="/memberInfoUpload.htm", method = RequestMethod.GET)
    public String page(ModelMap model) {

        return "memberInfoUpload";
    }
    @RequestMapping(value = "/importMemberInfo.json",method = RequestMethod.POST)

    public ModelAndView importMemberInfo(HttpServletRequest request, HttpServletResponse response,MultipartFile file, String fileName) {
        MultipartHttpServletRequest   multipartRequest   =   (MultipartHttpServletRequest)   request;
        String service= multipartRequest.getParameter("service");
        Map<String,Map<String,String>> allresultMap=new HashMap<String,Map<String,String>>();
        List<Map<String,String>> listMap=new ArrayList<Map<String, String>>();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<--------------"+service+"------------------->>>>>>>>>>>>>>>");
        long beginTime=System.currentTimeMillis();
        logger.info("批量导入会员信息开始:beginTime={}",beginTime);
        File uploadFile=null;
        if(!file.isEmpty()){
            try {
                logger.info("Precess file:{}"+file.getOriginalFilename());
                String path = System.getProperty("user.dir");
                String webappcontext=request.getSession().getServletContext().getRealPath("/");
                String  url= request.getRequestURL().toString();
                uploadFile=new File(webappcontext+"/file",file.getOriginalFilename());
                logger.info("webappcontext:"+webappcontext);
                logger.info("path:"+path);
                logger.info("fileloadname:{}",uploadFile.getName());
                logger.info("url:{}",url);
                //step1 如果不是excel文件，则不解析，也不上传
                String fileExtName=getExtensionName(file.getOriginalFilename());
                if (!fileExtName.equalsIgnoreCase("xls")&&!fileExtName.equalsIgnoreCase("xlsx")){
                    logger.error("上传文件不是excel文件");
                    Map<String,String> resultMap=new HashMap<String, String>();
                    resultMap.put("success","false");
                    resultMap.put("message","上传文件不是excel文件");
                //    return JSONObject.toJSONString(resultMap);
                }else{
                    FileUtils.copyInputStreamToFile(file.getInputStream(),new File(webappcontext+"/file",file.getOriginalFilename()));

                }
                //step2 读取excek文件，组装结果集
                Workbook workbook=readExcel(file.getInputStream(),listMap);
                //step3 遍历结果集，遍历调用开户接口
                batchCreteMember(service,listMap,allresultMap);
             //   batchCreteMemberTest((String)request.getAttribute("service"), listMap,allresultMap);
                //step 4 将调用结果集放入excel
                rewriteResultToExcel(workbook,allresultMap);
                //step 5 excell文件写入到硬盘
                //  FileUtils.copyInputStreamToFile(file.getInputStream(),new File(request.getContextPath()+"/file",System.currentTimeMillis()+file.getOriginalFilename()));
                // FileUtils.copyInputStreamToFile(file.getInputStream(),uploadFile);

                FileOutputStream fileOut = new FileOutputStream(uploadFile);
                workbook.write(fileOut);
                fileOut.close();
                fileOut.flush();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("批量上传个人会员出错{}",e.getMessage());
                Map<String,String> resultMap=new HashMap<String, String>();
                resultMap.put("success","false");
                resultMap.put("message",e.getMessage());
             //   return JSONObject.toJSONString(resultMap);
            }
            long endTime=System.currentTimeMillis();
            logger.info("批量导入会员信息结束:endTime={}",endTime);
            //return JSONObject.toJSONString(allresultMap);
        }else {
            logger.error("上传文件为空");
            Map<String,String> resultMap=new HashMap<String, String>();
            resultMap.put("success","false");
            resultMap.put("message","上传文件为空");
            //return JSONObject.toJSONString(resultMap);

        }
        return  new ModelAndView("memberInfoUpload", "filePath",file.getOriginalFilename());
    }


    public static  Workbook readExcel(InputStream is, List<Map<String,String>> listMap){


        try {

            //  FileInputStream is = new FileInputStream(excelFile); //文件流
            Workbook  workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的
            is.close();
            Sheet sheet = workbook.getSheetAt(0);//获取sheet1
            int rowCount=sheet.getPhysicalNumberOfRows();
            //第1行为标题行
            Row titleRow=sheet.getRow(0);
            List<String> titles=new ArrayList<String>();
            for(Iterator<Cell> rowTitleIter = titleRow.cellIterator();
                rowTitleIter.hasNext();){
                Cell titleCell=rowTitleIter.next();
                String titleContent= titleCell.getStringCellValue();
                titles.add(titleContent);//标题头加入数组，标题头作为数据的key
            }
            //从第2行开始遍历数据
            for (int i=1;i<rowCount;i++){
                Row dataRow=sheet.getRow(i);
                Map<String,String> dataMap=new HashMap<String, String>();
                for (int j=0;j<titles.size();j++){
                    Cell dataCell=dataRow.getCell(j);
                    if (dataCell!=null) {
                        dataCell.setCellType(Cell.CELL_TYPE_STRING);
                        String dataContent = dataCell.getRichStringCellValue().toString();
                        //登录密码使用SHA256位加密
                        if ("login_pwd".equals(titles.get(j))){
                             dataContent = UesUtils.hashSignContent(dataContent);
                         //   System.out.println("login_pwd"+dataContent);
                        }
                            dataMap.put(titles.get(j), dataContent);
                    }
                }
                listMap.add(dataMap);
            }
            return workbook;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  null;
    }

    /*
     * Java文件操作 获取文件扩展名
     *
     *  Created on: 2011-8-2
     *      Author: blueeagle
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }
    public static  void batchCreteMemberTest(String serviceName, List<Map<String,String>> listMap,Map<String,Map<String,String>> resultMap){
        for (Map<String,String> data:listMap){
            Map<String,String> result=new HashMap<String, String>();
            result.put("success", (Math.random()*10)%2==0?"true":"false");
            result.put("memo",Math.random()+"测试数据");

            resultMap.put(data.get("uid"),result);
        }
    }
    public   void batchCreteMember(String service, List<Map<String,String>> listMap,Map<String,Map<String,String>> resultMap){
        String inputCharset="UTF-8";
        String sign_type="RSA";
        String partner_id="188888888888";
        String version="1.0";


        Map<String,String> result=new HashMap<String, String>();
        for (Map<String,String> data:listMap){
            try {
                data.put("service",service);
                data.put("partner_id",partner_id);
                data.put("_input_charset",inputCharset);
                data.put("sign_type",sign_type);
                data.put("version",version);
                securityService.filter(data);
                SignData signData =securityService.sign(data, inputCharset, sign_type);
                data.put("sign",signData.getSign());
                result = remoteService.invoke(data, inputCharset);
                //结果集在key中，value中的值是空字符串，不知道谁这么设计的,简直坑爹
                for (String key : result.keySet()) {
                    JSONObject jsonObject= JSONObject.parseObject(key);

               String success = (String) jsonObject.get("is_success");
                    if("T".equals(success)){
                        result.put("success", "true");
                    }else{
                        result.put("success","false");
                    }
                }
                resultMap.put(data.get("uid"),result);
            } catch (Exception e) {
                e.printStackTrace();
                result.put("success","false");
                result.put("error", e.getMessage());
                resultMap.put(data.get("uid"),result);
            }
        }

    }
    public static void rewriteResultToExcel(Workbook workbook,Map<String,Map<String,String>> resultMap){
        Sheet sheet = workbook.getSheetAt(0);//获取sheet1
        int colCount=sheet.getRow(0).getPhysicalNumberOfCells();//获取第一行列个数，
        int rowCount=sheet.getPhysicalNumberOfRows();//获取行数
            //step1 创建调用结果result列

              Cell resultCellTitle=sheet.getRow(0).createCell(colCount);
              resultCellTitle.setCellType(Cell.CELL_TYPE_STRING);
              resultCellTitle.setCellValue("result");
            //step2获取uid所在列
             int uidIndex=0;
             while (!"uid".equalsIgnoreCase(sheet.getRow(0).getCell(uidIndex).getStringCellValue())){
                 uidIndex++;
             }
            //step3从第二行开始遍历表格，根据uid匹配，写入调用结果
            for (int i=1;i<rowCount;i++){
                String uidVlue=sheet.getRow(i).getCell(uidIndex).getStringCellValue();//获取excel表格当前行uid
                String result=JSONObject.toJSONString(resultMap.get(uidVlue));  //获取当前行uid所对应的调用结果
                Cell resultCell;
                if ( sheet.getRow(i).getCell(colCount)!=null){
                    resultCell=sheet.getRow(i).getCell(colCount);
                }else{
                    resultCell=sheet.getRow(i).createCell(colCount);
                }
                //如果不成功设置为红色，否则为绿色
                CellStyle  style= workbook.createCellStyle();;
                Font font =workbook.createFont();
                JSONObject jsonObj  =JSONObject.parseObject(result);
                style.setFont(font);
                if (!jsonObj.get("success").equals("false")){
                    font.setColor(HSSFColor.GREEN.index);
                }else{
                    font.setColor(HSSFColor.RED.index);
                }
                resultCell.setCellStyle(style);
                resultCell.setCellType(Cell.CELL_TYPE_STRING);
                resultCell.setCellValue(result); //将结果集写入excel表格result列
             }
    }
    public static void main(String[] args) {
        List<Map<String,String>> listMap=new ArrayList<Map<String, String>>();
        File file = new File("D:\\yinrong\\svn\\basis\\mgs-test\\branches\\xmz\\web\\src\\main\\webapp\\file\\20161102.xls");
        String serviceName="create_personal_member";
        Map<String,Map<String,String>> allresultMap=new HashMap<String,Map<String,String>>();
        try {
            FileInputStream is = new FileInputStream(file);
            Workbook workbook=readExcel(is,listMap);
            batchCreteMemberTest(serviceName, listMap,allresultMap);
            rewriteResultToExcel( workbook, allresultMap);
            System.out.println(listMap);
            FileOutputStream fileOut = new FileOutputStream(file);
            workbook.write(fileOut);
            fileOut.close();
            fileOut.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
