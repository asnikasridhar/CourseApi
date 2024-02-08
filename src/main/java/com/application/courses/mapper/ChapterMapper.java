package com.application.courses.mapper;

import com.application.courses.dto.ChapterDto;
import com.application.courses.entity.Chapter;

public class ChapterMapper {

	public static Chapter mapToChapter(ChapterDto chapterDto)
	{
		Chapter chapter = new Chapter(chapterDto.getChapter_id(),
				chapterDto.getChapter_name(), chapterDto.getCourse_id() 
				);
		return chapter;

	}

	public static ChapterDto mapToChapterDto(Chapter chapter)
	{
		ChapterDto chapterDto = new ChapterDto(
				chapter.getChapter_id(),
				chapter.getChapter_name(),
				chapter.getCourse_id()
				);
		return chapterDto;
	}

}
