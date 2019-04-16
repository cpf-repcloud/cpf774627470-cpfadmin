package cn.rep.cloud.custom.basecommon.post.service;


import cn.hutool.core.collection.CollectionUtil;
import cn.rep.cloud.custom.basecommon.post.business.RepGwServiceImpl;
import cn.rep.cloud.custom.basecommon.post.dto.PostRankDataDTO;
import cn.rep.cloud.custom.basecommon.post.dto.PostRankSearchDTO;
import cn.rep.cloud.custom.basecommon.post.vo.PostRankControlVO;
import cn.rep.cloud.custom.basecommon.post.vo.PostRankDataVO;
import cn.rep.cloud.custom.coreutils.common.IdGenerator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vetech on 2018/7/26.
 */
@Service
public class PostRankService {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(PostRankService.class);
    /**
     * 公司岗位实现类
     */
    @Autowired
    private RepGwServiceImpl veGwService;

    /**
     * 查询岗位列表 没有分页
     *
     * @param dto
     * @return
     */
    public List<PostRankDataVO> postRankList(PostRankSearchDTO dto) {
        logger.info("查询岗位列表 入参{}",dto);
        return veGwService.postRankList(dto);
    }


    /**
     * 添加员工岗位
     *
     * @param dataDTO
     * @return
     */
    public int addRank(PostRankDataDTO dataDTO) throws Exception {
        logger.info("新增岗位入参{}",dataDTO);
        if (StringUtils.isBlank(dataDTO.getGsid())) {
           // throw new SystemException(BaseExceptionEnum.BASE_POSTRANK_0000_04_0139);
        }
        dataDTO.setId(IdGenerator.getHexId());
        return veGwService.addRank(dataDTO);
    }

    /**
     * 编辑员工岗位
     *
     * @param dataDTO
     * @return
     */
    public int editRank(PostRankDataDTO dataDTO) throws Exception {
        logger.info("编辑岗位入参{}",dataDTO);
        if (StringUtils.isBlank(dataDTO.getGsid())) {
           // throw new SystemException(BaseExceptionEnum.BASE_POSTRANK_0000_04_0139);
        }
        return veGwService.editRank(dataDTO);
    }

    /**
     * 删除公司岗位
     *
     * @param dto
     * @return
     */
    public int deleteRank(PostRankDataDTO dto) {
        return veGwService.deleteRank(dto);
    }


    /**
     * 岗位控件
     *
     * @param dataDTO 传递参数
     * @return
     */
    public List<PostRankControlVO> getRankControl(PostRankSearchDTO dataDTO) {
        List<PostRankControlVO> postRankControlVOs = new ArrayList<>();
        List<PostRankDataVO> postRankDataVOs = this.postRankList(dataDTO);
        if (CollectionUtil.isNotEmpty(postRankDataVOs)) {
            for (PostRankDataVO oo : postRankDataVOs) {
                PostRankControlVO postRankControlVO = new PostRankControlVO();
                postRankControlVO.setId(oo.getId());
                postRankControlVO.setParentId(oo.getGwbh());
                postRankControlVO.setLabel(oo.getGwmc());
                postRankControlVO.setValue(oo.getGwbh());
                postRankControlVOs.add(postRankControlVO);
            }
        }
        return postRankControlVOs;
    }
}
