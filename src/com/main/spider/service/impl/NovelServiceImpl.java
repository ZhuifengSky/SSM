package com.main.spider.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.common.bean.Page;
import com.main.common.util.DateUtil;
import com.main.spider.bean.ChapterBean;
import com.main.spider.bean.ContentBean;
import com.main.spider.bean.NovelChapterBean;
import com.main.spider.dao.IChapterDao;
import com.main.spider.dao.INovelDao;
import com.main.spider.model.Chapter;
import com.main.spider.model.Novel;
import com.main.spider.service.INovelService;
import com.main.user.model.User;

@Service
public class NovelServiceImpl implements INovelService {

	@Autowired
	private INovelDao novelDaoImpl;
	@Autowired
	private IChapterDao chapterDaoImpl;
	
	
	
	private List<Novel> spiderNovel(NovelChapterBean novelBean) throws ParseException {
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
				ChapterBean chapterBean = new ChapterBean();
				chapterBean.setChapterUrl(novelBean.getBaseUrl()+"/"+element.select(novelBean.getDetailUrl()).attr("href"));
				chapterBean.setChapterPath(novelBean.getChapterPath());
				chapterBean.setChapterTitle(novelBean.getChapterTitle());
				chapterBean.setDescription(novelBean.getChapterDesc());
				chapterBean.setContentPath(novelBean.getContentPath());
				chapterBean.setContentUrl(novelBean.getContentUrl());
				novel.setChapterBean(chapterBean);
				novels.add(novel);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return novels;
	}
	
	
	private Novel getChapters(Novel novel){
		List<Chapter> chapters = new ArrayList<Chapter>();
		ChapterBean chapterBean = novel.getChapterBean();
		if (chapterBean!=null) {
			Connection conn = Jsoup.connect(chapterBean.getChapterUrl());
			try {
				// 10秒超时时间,发起get请求，也可以是post
	            Document document = conn.timeout(10000).get();
	            Elements elements = document.select(chapterBean.getChapterPath());
	            for (Element element : elements) {
	            	Chapter chapter = new Chapter();
	            	chapter.setTitle(element.select(chapterBean.getChapterTitle()).text());
	            	chapter.setDescription(element.select(chapterBean.getDescription()).attr("title"));
	            	chapter.setNovelId(Integer.parseInt(novel.getId()));
	            	ContentBean contentBean = new ContentBean();
	            	contentBean.setContentUrl("http:"+element.select(chapterBean.getContentUrl()).attr("href"));
	            	contentBean.setContentPath(chapterBean.getContentPath());
	            	chapter.setContentBean(contentBean);
	            	chapter = getChapterContent(chapter);
	            	chapters.add(chapter);
	            	novel.setChapters(chapters);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
			return novel;
		}else{
			return null;
		}
	}
	
	private Chapter getChapterContent(Chapter chapter){
		 ContentBean contentBean = chapter.getContentBean();
		if (contentBean!=null) {
			Connection conn = Jsoup.connect(contentBean.getContentUrl());
			try {
				// 10秒超时时间,发起get请求，也可以是post
	            Document document = conn.timeout(100000).get();
	            Elements elements = document.select(contentBean.getContentPath());
	            if (elements!=null && elements.size()==1) {
	            	chapter.setContent(elements.get(0).html());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
			return chapter;
		}else{
			return null;
		}
	}
	
	
	
	@Override
	public Page<Novel> findPage(Page<Novel> page, Novel queryBean) {
		queryBean.setPage(page);
		List<Novel> novels = novelDaoImpl.findList(queryBean);
		page.setList(novels);
		return page;
	}

	@Override
	public int saveNovels(NovelChapterBean spider) throws ParseException {
		List<Novel> novels = spiderNovel(spider);
		int result =0;
		if (novels!=null && novels.size()>0) {
			for (Novel novel : novels) {
				novelDaoImpl.insert(novel);
				novel = getChapters(novel);				
				List<Chapter> chapters = novel.getChapters();
				chapterDaoImpl.insertBatch(chapters);
				result++;
			}
		}
		return result;
		
	}


	@Override
	public List<Chapter> getNovelChapter(Chapter chapter) {
		return chapterDaoImpl.findList(chapter );
	}


	@Override
	public Chapter getChapterContent(String chapterId) {
		return chapterDaoImpl.getChapterDetail(Integer.parseInt(chapterId));
	}


	@Override
	public Novel getNovel(int novelId) {
		return novelDaoImpl.getNovel(novelId);
	}


	@Override
	public Chapter getLastNextChapter(Chapter chapter) {
		chapter.setFlag("last");
		chapter.setLastChapterId(chapterDaoImpl.getLastNextChapter(chapter));
		chapter.setFlag("next");
		chapter.setNextChapterId(chapterDaoImpl.getLastNextChapter(chapter));
		return chapter;
	}

}
