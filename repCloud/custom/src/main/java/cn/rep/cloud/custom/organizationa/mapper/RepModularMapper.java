package cn.rep.cloud.custom.organizationa.mapper;

import cn.rep.cloud.custom.organizationa.dto.RepModularDTO;
import cn.rep.cloud.custom.organizationa.entity.RepModular;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "repModularMapper")
public interface RepModularMapper extends BaseMapper<RepModular> {

    List<RepModular> pagelist(Page page, @Param("dto")RepModularDTO dto);
}
