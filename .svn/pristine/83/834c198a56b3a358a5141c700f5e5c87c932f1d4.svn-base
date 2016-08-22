package com.zjlppz.bean.viewbean ;

import java.io.Serializable ;
import java.util.List ;

import com.zjlppz.bean.Category ;
import com.zjlppz.bean.Goods ;

/**
 * 大类别商品实体类
 * 
 * @author liangruihua
 * 
 */
public class CategoryGoods extends Category implements Serializable
{
	private List < Goods > CategoryGoods ;

	public List < Goods > getCategoryGoods ( )
	{
		return CategoryGoods ;
	}

	public void setCategoryGoods ( List < Goods > categoryGoods )
	{
		CategoryGoods = categoryGoods ;
	}

	public CategoryGoods ( List < Goods > categoryGoods )
	{
		super ( ) ;
		CategoryGoods = categoryGoods ;
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

	@Override
	public String toString ( )
	{
		return "CategoryGoods [CategoryGoods=" + CategoryGoods + "]" ;
	}

	
	
}
