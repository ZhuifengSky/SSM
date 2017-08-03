package com.main.spider.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.main.spider.bean.ContentListBean;
import com.main.spider.model.Spider;
import com.main.spider.service.ISpiderService;

@Service
public class SpiderServiceImpl implements ISpiderService {

	@Override
	public List<ContentListBean> getTargetContent(Spider spider) {
		if (spider != null) {
			if (spider.getEncodingType()==null) {
				spider.setEncodingType("utf-8");
			}
			List<ContentListBean> contentBeans = new ArrayList<ContentListBean>();
			HttpGet request = new HttpGet(spider.getTargetUrl());// ���﷢��get����
			// ��ȡ��ǰ�ͻ��˶���
			CloseableHttpClient httpClient = HttpClients.createDefault();
			// ͨ����������ȡ��Ӧ����
			CloseableHttpResponse response = null;
			try {
				response = httpClient.execute(request);
				// �ж���������״̬���Ƿ�����(0--200��������)
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						Document document = Jsoup.parse(EntityUtils.toString(entity,spider.getEncodingType()));
						 Elements elements = document.select(spider.getTargetPath());
			            for (Element element : elements) {
			            	ContentListBean contentBean = new ContentListBean();
			            	contentBean.setTitle(element.text());
			            	contentBean.setUrl(element.baseUri());
			            	contentBeans.add(contentBean);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					response.close();
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return contentBeans;
		} else {
			return null;
		}
	}

	@Override
	public List<ContentListBean> getTargetContentByJsoup(Spider spider) {
		List<ContentListBean> contentBeans = new ArrayList<ContentListBean>();
		Connection conn = Jsoup.connect(spider.getTargetUrl());
		try {
			// 10�볬ʱʱ��,����get����Ҳ������post
            Document document = conn.timeout(10000).get();
            Elements elements = document.select(spider.getTargetPath());
            for (Element element : elements) {
            	ContentListBean contentBean = new ContentListBean();
            	contentBean.setTitle(element.text());
            	contentBean.setUrl(element.baseUri()+element.attr("href"));
            	contentBeans.add(contentBean);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return contentBeans;
	}

}
