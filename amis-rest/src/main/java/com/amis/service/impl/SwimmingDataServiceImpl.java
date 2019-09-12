package com.amis.service.impl;

import com.amis.dao.SwimmingDataDao;
import com.amis.entity.MotionDataEntity;
import com.amis.entity.dto.ReturnSwimmingDataDTO;
import com.amis.service.SwimmingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SwimmingDataServiceImpl
 * @Description
 * @Author chenzexin
 * @Date 2019/9/10 18:52
 **/
@Service
public class SwimmingDataServiceImpl implements SwimmingDataService {

    @Autowired
    private SwimmingDataDao swimmingDataDao;

    @Override
    public int insertSwimmingData(MotionDataEntity motionDataEntity) {
        return swimmingDataDao.insertSwimmingData(motionDataEntity);
    }

    @Override
    public List<MotionDataEntity> getSwimmingDataExcel() {
        return swimmingDataDao.getSwimmingDataExcel();
    }

    @Override
    public List<ReturnSwimmingDataDTO> analysisMotionDataEntity(List<MotionDataEntity> rows) throws IOException {
        List<ReturnSwimmingDataDTO> returnSwimmingDataDTOS = new ArrayList<>();
        for (MotionDataEntity row : rows){
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] data = base64Decoder.decodeBuffer(row.getData());
            int index = 0;
            for (int a = 0; a < 20;a++){
                index = a * 12;
                ReturnSwimmingDataDTO returnSwimmingDataDTO = new ReturnSwimmingDataDTO();
                returnSwimmingDataDTO.setAx(byteArrayToInt(data[index+0],data[index+1])/2048f);
                returnSwimmingDataDTO.setAy(byteArrayToInt(data[index+2],data[index+3])/2048f);
                returnSwimmingDataDTO.setAz(byteArrayToInt(data[index+4],data[index+5])/2048f);
                returnSwimmingDataDTO.setGx(byteArrayToInt(data[index+6],data[index+7])/ 16.4f);
                returnSwimmingDataDTO.setGy(byteArrayToInt(data[index+8],data[index+9])/ 16.4f);
                returnSwimmingDataDTO.setGz(byteArrayToInt(data[index+10],data[index+11])/ 16.4f);
                returnSwimmingDataDTOS.add(returnSwimmingDataDTO);
            }
        }
        return returnSwimmingDataDTOS;
    }

    @Override
    public void truncateTable() {
        swimmingDataDao.truncateTable();
    }


    public static int byteArrayToInt(byte byte1,byte byte2) {
        return (byte2 << 8) | (byte1 & 0xFF);
    }
}
