package com.example.yin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.yin.model.domain.SongList;
import org.springframework.stereotype.Repository;

@Repository

public interface SongListMapper extends BaseMapper<SongList> {


    Page<SongList> songListPage(IPage<?> page);
}
