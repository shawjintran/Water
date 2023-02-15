package com.t.water.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.water.entity.Sensor;
import com.t.water.service.SensorService;
import com.t.water.mapper.SensorMapper;
import org.springframework.stereotype.Service;

/**
* @author 李可文
* @description 针对表【sensor】的数据库操作Service实现
* @createDate 2023-02-14 11:49:28
*/
@Service
public class SensorServiceImpl extends ServiceImpl<SensorMapper, Sensor>
    implements SensorService{

}




