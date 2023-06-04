package com.mxt.Upload.service;

import com.mxt.Upload.dao.UploadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadService {
    @Autowired(required = false)
    UploadDao uploadDao;
    public String SSRFModal1() {
        return  uploadDao.SSRF1();
    }


}
