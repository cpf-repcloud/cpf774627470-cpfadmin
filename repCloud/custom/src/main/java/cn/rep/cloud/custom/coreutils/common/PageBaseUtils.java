package cn.rep.cloud.custom.coreutils.common;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PageBaseUtils<T> {
    @Autowired
    private BaseMapper<T> baseMapper;
    /**
     * 查询分页
     *  pageDTO.getCurrent() - 1 * pageDTO.getSize() 查询时开始条数
     * @param pageDTO
     * @return
     */
    public PageNew seletPage(PageDTO<T> pageDTO,EntityWrapper<T> ew){
        PageNew pageNew = new PageNew();
        int current = (pageDTO.getCurrent() - 1) * pageDTO.getSize();
        int size = pageDTO.getSize();
        RowBounds rowBounds = new RowBounds(current, size);
        List<T> list = baseMapper.selectPage(rowBounds,ew);
        int totalCount = baseMapper.selectCount(ew);
        pageNew.setTotal(totalCount);
        pageNew.setCurrent(pageDTO.getCurrent());
        pageNew.setSize(pageDTO.getSize());
        pageNew.setPages(totalCount/pageDTO.getSize());
        pageNew.setPageList(list);
        return pageNew;
    }

}
