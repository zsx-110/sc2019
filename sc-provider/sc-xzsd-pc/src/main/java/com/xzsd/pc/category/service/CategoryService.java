package com.xzsd.pc.category.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.category.dao.CategoryDao;
import com.xzsd.pc.category.entity.CategoryList;
import com.xzsd.pc.category.entity.GoodsCategory;
import com.xzsd.pc.category.entity.GoodsCategoryVO;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author zsx
 * @Date 2020-04-14
 */
@Service
public class CategoryService {

    @Resource
    private CategoryDao categoryDao;

    /**
     * 新增商品分类
     * @param goodsCategory
     * @param loginId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsCategory(GoodsCategory goodsCategory, String loginId){

        //校验是否存在相同的分类名
        int count = categoryDao.countGoodsCategoryName(goodsCategory);
        if(count != 0){
            return AppResponse.bizError("存在相同的分类名，请重新输入！");
        }
        goodsCategory.setClassifyId(StringUtil.getCommonCode(2));
        goodsCategory.setIsDelete(0);
        goodsCategory.setCreateUser(loginId);
        //判断是否插入成功
        int categoryNum = categoryDao.addGoodsCategory(goodsCategory);
        if(categoryNum == 0){
            return AppResponse.bizError("新增失败！");
        }
        return AppResponse.success("新增成功！");
    }


    /**
     * 查询商品分类详情
     * @param categoryId
     * @return
     */
    public AppResponse getGoodsCategoryById(String categoryId){
        GoodsCategoryVO goodsCategory = categoryDao.getGoodsCategoryById(categoryId);
        if(goodsCategory == null){
            return AppResponse.bizError("查询分类详情失败！");
        }
        return AppResponse.success("查询分类详情成功！", goodsCategory);
    }

    /**
     * 修改商品分类信息
     * @param goodsCategory
     * @param loginId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsCategoryById(GoodsCategory goodsCategory, String loginId){
        GoodsCategoryVO category = categoryDao.getGoodsCategoryById(goodsCategory.getClassifyId());
        int count = categoryDao.countGoodsCategoryName(goodsCategory);
        //判断当前的分类名称是否存在相同的，只有修改后存在相同的分类名才会提示重新输入
        if(count != 0 && category.getClassifyName().equals(goodsCategory.getClassifyName()) == false){
            return AppResponse.bizError("存在相同的分类名，请重新输入！");
        }
        goodsCategory.setUpdateUser(loginId);
        int categoryNum = categoryDao.updateGoodsCategoryById(goodsCategory);
        if(categoryNum == 0){
            return AppResponse.bizError("修改失败！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 查询商品分类列表
     * @return
     */
    public AppResponse getListGoodsCategory(){
        List<GoodsCategoryVO> listGoodsCategory = categoryDao.getListFirstAndSecondGoodsCategory();
        CategoryList categoryList = new CategoryList();
        categoryList.setOneClassifyList(listGoodsCategory);
        return AppResponse.success("查询成功！", categoryList);
    }

    /**
     * 删除商品分类
     * @param categoryId
     * @param loginId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsCategory(String categoryId, String loginId){
        //查询是否存在二级分类
        int num = categoryDao.countParentId(categoryId);
        if(num != 0){
            return AppResponse.bizError("存在二级分类，不能删除！");
        }
        int count = categoryDao.deleteGoodsCategory(categoryId, loginId);
        if(count == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }
}
