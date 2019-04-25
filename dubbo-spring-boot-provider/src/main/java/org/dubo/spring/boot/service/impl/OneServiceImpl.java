package org.dubo.spring.boot.service.impl;

import org.dubbo.spring.boot.service.OneService;
import org.dubbo.spring.boot.service.TwoService;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

@com.alibaba.dubbo.config.annotation.Service(interfaceClass = OneService.class)
@Service
public class OneServiceImpl implements OneService {

	@Reference(check = false)
	private TwoService twoService;

	@Override
	public String one(String s) {
		String result = "";
		try {
			result = twoService.two(s);
		} catch (Exception e) {
			result = "invoke twoservice fail!";
		}
		return "oneservice ivoke success!" + result;
	}
}
