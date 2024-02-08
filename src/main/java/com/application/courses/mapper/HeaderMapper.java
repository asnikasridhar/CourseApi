package com.application.courses.mapper;

import com.application.courses.dto.HeaderDto;
import com.application.courses.entity.Header;

public class HeaderMapper {

	public static Header mapToHeader(HeaderDto headerDto)
	{
		Header header = new Header(headerDto.getHeader_id(),
				headerDto.getHeader_name(), headerDto.getChapter_id() 
				);
		return header;

	}

	public static HeaderDto mapToHeaderDto(Header header)
	{
		HeaderDto headerDto = new HeaderDto(
				header.getHeader_id(),
				header.getHeader_name(),
				header.getChapter_id()
				);
		return headerDto;
	}

}
