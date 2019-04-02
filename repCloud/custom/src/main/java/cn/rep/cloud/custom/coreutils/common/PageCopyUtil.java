package cn.rep.cloud.custom.coreutils.common;

import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

public class PageCopyUtil {

    /**
     * 拷贝分页
     *
     * @param sourcePage             源
     * @param  sourceClass page中的对象
     * @param destinationClass 需要拷贝到的目标class
     * @param <S>              源
     * @param <D>              目标
     * @return 新的分页对象
     */
    public static <S, D> Page<D> copy(Page<S> sourcePage, Class<S> sourceClass, Class<D> destinationClass) {
        if (sourcePage == null || destinationClass == null) {
            throw new MybatisPlusException("分页拷贝异常，源或目标为null");
        }
        Page newPage = new Page(sourcePage.getCurrent(), sourcePage.getSize(), sourcePage.getOrderByField());
        newPage.setAsc(sourcePage.isAsc());
        newPage.setTotal(sourcePage.getTotal());

        List<S> listE = sourcePage.getRecords();
//        if (listE != null) {
//            Type<S> sourceType = BeanMapper.getType(sourceClass);
//            Type<D> targetType = BeanMapper.getType(destinationClass);
//            List<D> listT =   BeanMapper.mapList(listE,sourceType,targetType);
//            newPage.setRecords(listT);
//        }
        return newPage;
    }

    /**
     * 拷贝分页，浅拷贝 只拷贝分页信息 不拷贝数据
     * @param page 源
     * @return   目标
     */
    public static Page copy(Page page){
        if (page == null) {
            throw new MybatisPlusException("分页拷贝异常，源或目标为null");
        }
        Page newPage = new Page(page.getCurrent(), page.getSize(), page.getOrderByField());
        newPage.setAsc(page.isAsc());
        newPage.setTotal(page.getTotal());
        return newPage;
    }

    /**
     * 拷贝分页查询对象
     *
     * @param sourcePageDTO             源
     * @param sourceClass page中的对象
     * @param destinationClass 需要拷贝到的目标class
     * @param <S>              源
     * @param <D>              目标
     * @return 新的分页查询对象
     */
    public static <S, D> PageDTO<D> copyDTO(PageDTO<S> sourcePageDTO, Class<S> sourceClass, Class<D> destinationClass) {
        if (sourcePageDTO == null || destinationClass == null) {
            throw new MybatisPlusException("分页DTO拷贝异常，源或目标为null");
        }
        PageDTO newPageDTO = new PageDTO();
        newPageDTO.setSize(sourcePageDTO.getSize());
        newPageDTO.setCurrent(sourcePageDTO.getCurrent());
        newPageDTO.setOrderByField(sourcePageDTO.getOrderByProperty());//原始值拷贝
        newPageDTO.setAsc(sourcePageDTO.isAsc());

        S sData = sourcePageDTO.getData();
//        if (sData != null) {
//            Type<S> sourceType = BeanMapper.getType(sourceClass);
//            Type<D> targetType = BeanMapper.getType(destinationClass);
//            D dData = BeanMapper.map(sData,sourceType,targetType);
//            newPageDTO.setData(dData);
//        }
        return newPageDTO;
    }

    /**
     * 转化为Page对象
     *
     * @return page
     */
    public static Page genPage(PageDTO pageDTO) {
        Page page = new Page<>(pageDTO.getCurrent(), pageDTO.getSize(), pageDTO.getOrderByField());
        page.setAsc(pageDTO.isAsc());
        return page;
    }
}
