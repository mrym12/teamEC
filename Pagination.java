package com.internousdev.i1810a.util;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.i1810a.dto.PaginationDTO;
import com.internousdev.i1810a.dto.ProductInfoDTO;

public class Pagination {
	public PaginationDTO initialize(List<ProductInfoDTO>list, int pageSize){
		PaginationDTO paginationDTO = new PaginationDTO();
//		全ページ数
		paginationDTO.setTotalPageSize((int)(Math.ceil((double)list.size()/pageSize)));
//		現在のページ数
		paginationDTO.setCurrentPageNo(1);
//		全レコード数
		paginationDTO.setTotalRecordSize(list.size() - 1);
//		現在のページ番号に対する開始レコード番号（オフセット）
		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() -1));
//		現在のページ番号に対する終了レコード番号
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() +(pageSize - 1));

//		ページ数表示
		List<Integer>pageNumberList = new ArrayList<Integer>();
		for(int pageNumber=1;pageNumber<=paginationDTO.getTotalPageSize();pageNumber++){
			pageNumberList.add(pageNumber);
		}
//		リスト番号が存在するか確認
 		boolean existence = false;
 		while(!(existence)) {
 			existence = true;
 			try {
 				list.get(paginationDTO.getEndRecordNo());
 			}catch(IndexOutOfBoundsException e){
 				paginationDTO.setEndRecordNo(paginationDTO.getEndRecordNo() -1);
 				existence = false;
 			}
 		}
		List<ProductInfoDTO>productInfoPages=new ArrayList<ProductInfoDTO>();
		for(int pageNumberOffset=paginationDTO.getStartRecordNo();
				pageNumberOffset <= paginationDTO.getEndRecordNo();
				pageNumberOffset++){
			productInfoPages.add(list.get(pageNumberOffset));
		}
		paginationDTO.setCurrentProductInfoPage(productInfoPages);

		if((paginationDTO.getStartRecordNo() -1 )<= 0){
			paginationDTO.setHasPreviousPage(false);
		}else{
			paginationDTO.setHasPreviousPage(true);
			paginationDTO.setPreviousPageNo(paginationDTO.getCurrentPageNo()-1);
		}

		if(paginationDTO.getEndRecordNo()+pageSize > paginationDTO.getTotalRecordSize()){
			paginationDTO.setHasNextPage(false);
		}else{
			paginationDTO.setHasNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo());
		}
		return paginationDTO;
	}
	 	public PaginationDTO getPage(List<ProductInfoDTO> list, int pageSize, String pageNo) {
	 		PaginationDTO paginationDTO = new PaginationDTO();
	 		// 全ページ数
	 		paginationDTO.setTotalPageSize((int)(Math.ceil((double)list.size() / pageSize)));
	 		// 現在のページ番号
	 		paginationDTO.setCurrentPageNo(Integer.parseInt(pageNo));
	 		// 全レコード数
	 		paginationDTO.setTotalRecordSize(list.size() - 1);
	 		// 現在のページ番号に対する開始レコード番号（オフセット）　　　　　リスト内no開始
	 		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() -1));
	 		// 現在のページ番号に対する終了レコード番号
	 		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + (pageSize -1));
//			ページ数表示
	 		List<Integer> pageNumberList = new ArrayList<Integer>();
	 		for(int pageNumber = 1;pageNumber <= paginationDTO.getTotalPageSize(); pageNumber++) {
	 			pageNumberList.add(pageNumber);
	 		}
//			リスト番号が存在するか確認
	 		boolean existence = false;
	 		while(!(existence)) {
	 			existence = true;
	 			try {
	 				list.get(paginationDTO.getEndRecordNo());
	 			}catch(IndexOutOfBoundsException e){
	 				paginationDTO.setEndRecordNo(paginationDTO.getEndRecordNo() -1);
	 				existence = false;
	 			}
	 		}
//			ページごとに要素を取り出す
	 		List<ProductInfoDTO> productInfoPages = new ArrayList<ProductInfoDTO>();
	 		for(int i=paginationDTO.getStartRecordNo(); i < paginationDTO.getEndRecordNo()+1; i++) {
	 			productInfoPages.add(list.get(i));
	 		}
//			それぞれのページにとりだした要素を送る
	 		paginationDTO.setCurrentProductInfoPage(productInfoPages);
	 		if((paginationDTO.getStartRecordNo()) <= 0) {
	 			paginationDTO.setHasPreviousPage(false);
	 		}else {
	 			paginationDTO.setHasPreviousPage(true);
	 			paginationDTO.setPreviousPageNo(paginationDTO.getCurrentPageNo());
	 		}

	 		if(paginationDTO.getEndRecordNo() + pageSize > paginationDTO.getTotalRecordSize()) {
	 			paginationDTO.setHasNextPage(false);
	 		}else {
	 			paginationDTO.setHasNextPage(true);
	 			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo());
	 		}
	 		return paginationDTO;
	 	}
}
