package com.main.spider.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.common.bean.Page;
import com.main.common.util.DateUtil;
import com.main.spider.bean.ContentListBean;
import com.main.spider.bean.NovelBean;
import com.main.spider.bean.SpiderBean;
import com.main.spider.dao.INovelDao;
import com.main.spider.model.Novel;
import com.main.spider.service.ISpiderService;
import com.main.user.model.User;

@Service
public class SpiderServiceImpl implements ISpiderService {

	@Autowired
	private INovelDao novelDaoImpl;
	
	@Override
	public List<ContentListBean> getTargetContent(SpiderBean spider) {
		if (spider != null) {
			if (spider.getEncodingType()==null) {
				spider.setEncodingType("utf-8");
			}
			List<ContentListBean> contentBeans = new ArrayList<ContentListBean>();
			HttpGet request = new HttpGet(spider.getTargetUrl());// 这里发送get请求
			// 获取当前客户端对象
			CloseableHttpClient httpClient = HttpClients.createDefault();
			// 通过请求对象获取响应对象
			CloseableHttpResponse response = null;
			try {
				response = httpClient.execute(request);
				// 判断网络连接状态码是否正常(0--200都数正常)
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
	public List<ContentListBean> getTargetContentByJsoup(SpiderBean spider) {
		List<ContentListBean> contentBeans = new ArrayList<ContentListBean>();
		Connection conn = Jsoup.connect(spider.getTargetUrl());
		try {
			// 10秒超时时间,发起get请求，也可以是post
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

	
	private List<Novel> spiderNovel(NovelBean novelBean) throws ParseException {
		List<Novel> novels = new ArrayList<Novel>();
		User addUser = new User();
		addUser.setId("1");
		Connection conn = Jsoup.connect(novelBean.getTargetUrl());
		try {
			// 10秒超时时间,发起get请求，也可以是post
            Document document = conn.timeout(10000).get();
            Elements elements = document.select(novelBean.getTargetPath());
            SimpleDateFormat sf = new SimpleDateFormat(DateUtil.BOTH);
            for (Element element : elements) {
            	Novel novel = new Novel();
            	novel.setTitle(element.select(novelBean.getTitle()).text());
            	novel.setAuthor(element.select(novelBean.getAuthor()).text());
            	novel.setCoverImage(element.select(novelBean.getCoverImage()).attr("src"));
            	novel.setDescription(element.select(novelBean.getDescription()).text());
            	novel.setType(element.select(novelBean.getType()).text());
            	novel.setStatus(element.select(novelBean.getStatus()).text());
            	novel.setCreateDate(sf.parse(sf.format(new Date())));
				novel.setCreateBy(addUser);
				novels.add(novel);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return novels;
	}

	@Override
	public Page<Novel> findPage(Page<Novel> page, Novel queryBean) {
		queryBean.setPage(page);
		List<Novel> novels = novelDaoImpl.findList(queryBean);
		page.setList(novels);
		return page;
	}

	@Override
	public int saveNovels(NovelBean spider) throws ParseException {
		List<Novel> novels = spiderNovel(spider);
		if (novels!=null && novels.size()>0) {
			return novelDaoImpl.insertBatch(novels);
		}
		return 0;
		
	}

}
