package com.t.water.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.water.entity.Manager;
import com.t.water.service.ManagerService;
import com.t.water.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

/**
* @author 李可文
* @description 针对表【manager】的数据库操作Service实现
* @createDate 2023-02-02 15:40:32
*/
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager>
    implements ManagerService{

}




