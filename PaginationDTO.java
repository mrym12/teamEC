package com.internousdev.i1810a.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaginationDTO {
	
	private int totalPageSize;
	private int currentPageNo;
	private int totalRecordSize;
	private int startRecordNo;
	private int endRecordNo;
	private List<Integer> pageNumberList = new ArrayList<Integer>();
	private List<ProductInfoDTO>currentProductInfoPage;
	private boolean hasNextPage;
	private boolean hasPreviousPage;
	private int nextPageNo;
	private int previousPageNo;
}
