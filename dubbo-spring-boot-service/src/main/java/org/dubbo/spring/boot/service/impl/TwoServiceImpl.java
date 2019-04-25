package org.dubbo.spring.boot.service.impl;

import org.dubbo.spring.boot.service.TwoService;
import org.springframework.stereotype.Service;

@com.alibaba.dubbo.config.annotation.Service(interfaceClass = TwoService.class)
@Service
public class TwoServiceImpl implements TwoService {

	@Override
	public String two(String s) {

		return "two service invoke success! hello, " + s;
	}

}
