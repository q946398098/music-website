package com.example.yin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.yin.model.domain.Banner;
import org.apache.ibatis.annotations.Mapper;

/**
* @author asus
* @description 针对表【banner】的数据库操作Mapper
* @createDate 2022-06-13 13:13:42
* @Entity generator.domain.Banner
*/
@Mapper
public interface BannerMapper extends BaseMapper<Banner> {


}
