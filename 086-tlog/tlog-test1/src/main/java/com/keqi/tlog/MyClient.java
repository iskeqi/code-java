package com.keqi.tlog;


import com.dtflys.forest.annotation.Get;
import com.yomahub.tlog.forest.TLogForestInterceptor;

public interface MyClient {

	@Get(url = "http://127.0.0.1:8080/demo2", interceptor = TLogForestInterceptor.class)
	void helloForest(String id);

}
