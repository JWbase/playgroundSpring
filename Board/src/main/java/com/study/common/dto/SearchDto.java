package com.study.common.dto;

import com.study.common.paging.Pagination;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchDto {

    private int page;
    private int recordSize;
    private int pageSize;
    private String keyword;
    private String searchType;
    private Pagination pagination;

    public SearchDto() {
        this.page = 1;
        this.recordSize = 10;
        this.pageSize = 10;
    }

}
