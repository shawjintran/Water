package com.t.water.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.water.entity.SensorInformation;
import com.t.water.service.SensorInformationService;
import com.t.water.mapper.SensorInformationMapper;
import org.springframework.stereotype.Service;

/**
* @author sky
* @description 针对表【sensor_information】的数据库操作Service实现
* @createDate 2023-01-18 18:48:40
*/
@Service
public class SensorInformationServiceImpl extends ServiceImpl<SensorInformationMapper, SensorInformation>
    implements SensorInformationService{

}




