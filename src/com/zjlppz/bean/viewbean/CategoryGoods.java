package com.zjlppz.bean.viewbean ;

import java.io.Serializable ;
import java.util.List ;

import com.zjlppz.bean.Category ;
import com.zjlppz.bean.Goods ;
import com.zjlppz.util.PageUtil ;

/**
 * 大类别商品实体类
 * 
 * @author liangruihua
 * 
 */
public class CategoryGoods extends Category implements Serializable
{
	private PageUtil < Goods > pageCategoryGoods ;

	public PageUtil < Goods > getPageCategoryGoods ( )
	{
		return pageCategoryGoods ;
	}

	public void setPageCategoryGoods ( PageUtil < Goods > pageCategoryGoods )
	{
		this.pageCategoryGoods = pageCategoryGoods ;
	}

	public CategoryGoods ( PageUtil < Goods > pageCategoryGoods )
	{
		super ( ) ;
		this.pageCategoryGoods = pageCategoryGoods ;
	}

	public CategoryGoods ( )
	{
		super ( ) ;
	}

	public CategoryGoods ( Integer categoryId , Integer parentId ,
			String categoryName )
	{
		super ( categoryId , parentId , categoryName ) ;
	}

	
	
}
