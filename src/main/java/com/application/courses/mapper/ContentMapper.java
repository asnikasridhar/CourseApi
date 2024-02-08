package com.application.courses.mapper;

import com.application.courses.dto.ContentDto;
import com.application.courses.entity.Content;

public class ContentMapper {

	public static Content mapToContent(ContentDto contentDto)
	{
		Content content = new Content(contentDto.getContent_id(),
				contentDto.getContent_name(), contentDto.getHeader_id() 
				);
		return content;

	}

	public static ContentDto mapToContentDto(Content content)
	{
		ContentDto contentDto = new ContentDto(
				content.getContent_id(),
				content.getContent_name(),
				content.getHeader_id()
				);
		return contentDto;
	}

}
