/**
 *
 */
package com.netfinworks.member.gateway.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.meidusa.fastjson.JSON;
import com.netfinworks.member.gateway.common.GatewayConstant;
import com.netfinworks.member.gateway.lang.util.GlobalResource;

/**
 * <p>注释</p>
 * @author fjl
 * @version $Id: PersonalService.java, v 0.1 2013-12-20 下午2:03:11 fjl Exp $
 */
@Service
public class RemoteService {
    private static Logger logger = LoggerFactory.getLogger(RemoteService.class);

    @Resource
    private GlobalResource globalResource;

    public Map<String, String> invoke(Map<String, String> data, String charset) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        HttpPost post = new HttpPost((String)globalResource.get("mgs.web"));
        try {

            if(logger.isInfoEnabled()){
                logger.info("发送给会员网关，编码前信息:{}",JSON.toJSON(data));
            }
            List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();

            for(Map.Entry<String, String> entry : data.entrySet()){
                String value = entry.getValue();
                if(StringUtils.hasText(value)){
                    String encode = URLEncoder.encode(value,charset);
//                    String encode = value;
                    formparams.add(new BasicNameValuePair(entry.getKey(), encode));
                }else{
                    formparams.add(new BasicNameValuePair(entry.getKey(),value));
                }
            }

            UrlEncodedFormEntity entity = null;
            try {
                entity = new UrlEncodedFormEntity(formparams, charset);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            post.setEntity(entity);
            String txt = httpClient.execute(post,getHandler(charset));

            if(logger.isInfoEnabled()){
                logger.info("会员网关响应字符串:{}",txt);
            }

            Map<String,String> map = decode(txt,charset);

            if(logger.isInfoEnabled()){
                logger.info("会员网关响应字符串,解码后的结果:{}",JSON.toJSON(map));
            }
            return map;
        }catch (Exception e) {
            logger.error("调用会员网关出错",e);
            throw e;
        }finally{
            if (httpClient != null) {
                try {
                    httpClient.getConnectionManager().shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public ResponseHandler<String> getHandler(final String charset){
        ResponseHandler<String> handler = new ResponseHandler<String>() {
            public String handleResponse(HttpResponse response)
                    throws ClientProtocolException, IOException {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String rest = new String(EntityUtils.toByteArray(entity),charset);
                    EntityUtils.consume(entity);
                    return rest;
                } else {
                    return null;
                }
            }
        };
        return handler;
    }

    public Map<String, String> decode(String formEncodedString,String charset) throws UnsupportedEncodingException{
        if(formEncodedString != null){
            String[] nameValuePairs = formEncodedString.split(GatewayConstant.and);
            Map<String, String> mapdata = new HashMap<String, String>();
            for(String nameValuePair : nameValuePairs){
                String [] nameValue = nameValuePair.split(GatewayConstant.eq);
                String name = nameValue[0];
                String value = nameValue.length > 1 ? nameValue[1] : GatewayConstant.empty;
                if(StringUtils.hasText(value)){
                    value = URLDecoder.decode(value,charset);
                }
                mapdata.put(name, value);
            }
            return mapdata;
        }
        return null;
    }

}
