package com.t.water.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.water.entity.DevInformation;
import com.t.water.service.DevInformationService;
import com.t.water.mapper.DevInformationMapper;
import org.springframework.stereotype.Service;

/**
* @author sky
* @description 针对表【dev_information】的数据库操作Service实现
* @createDate 2023-01-18 18:48:40
*/
@Service
public class DevInformationServiceImpl extends ServiceImpl<DevInformationMapper, DevInformation>
    implements DevInformationService{

}




