package com.ecommerce.project.payload;


import java.util.List;

public class CategoryResponse {
   private List<CategoryDTO> content;
   private Integer pageNumber;
   private Integer pageSize;
   private Long totalElements;
   private Integer totalPages;
   private boolean lastPage;

   public CategoryResponse() {
   }

   public CategoryResponse(List<CategoryDTO> content, boolean lastPage, Integer pageNumber, Integer pageSize, Long totalElements, Integer totalPages) {
      this.content = content;
      this.lastPage = lastPage;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
      this.totalElements = totalElements;
      this.totalPages = totalPages;
   }

   public List<CategoryDTO> getContent() {
      return content;
   }

   public void setContent(List<CategoryDTO> content) {
      this.content = content;
   }

   public boolean isLastPage() {
      return lastPage;
   }

   public void setLastPage(boolean lastPage) {
      this.lastPage = lastPage;
   }

   public Integer getPageNumber() {
      return pageNumber;
   }

   public void setPageNumber(Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public Integer getPageSize() {
      return pageSize;
   }

   public void setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
   }

   public Long getTotalElements() {
      return totalElements;
   }

   public void setTotalElements(Long totalElements) {
      this.totalElements = totalElements;
   }

   public Integer getTotalPages() {
      return totalPages;
   }

   public void setTotalPages(Integer totalPages) {
      this.totalPages = totalPages;
   }
}
