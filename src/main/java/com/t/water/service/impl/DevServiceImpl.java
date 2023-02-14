package com.t.water.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.water.entity.Dev;
import com.t.water.service.DevService;
import com.t.water.mapper.DevMapper;
import org.springframework.stereotype.Service;

/**
* @author 李可文
* @description 针对表【dev】的数据库操作Service实现
* @createDate 2023-02-14 10:40:30
*/
@Service
public class DevServiceImpl extends ServiceImpl<DevMapper, Dev>
    implements DevService{

}




