package com.ecommerce.ProductService.model.v1;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SearchCriteriaBaseModel<T> extends Object {

    private Integer pageSize;
    private Long totalCount;
    private Integer pageNumber;
    private List<?> content;


}
