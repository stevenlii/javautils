package com.paymoon.demo.httpClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
/**
 * select * from supplier_price where status = 3 and audit_auto=2 and start_time <1572327112 and end_time>1572327112 order by u_t desc 
 * @author MC
 *
 */
public class SyncDataTest {
	private static final Logger logger = LoggerFactory.getLogger(SyncDataTest.class);
	private static final int MAX_SIZE = 40;
	
	public static void main(String[] args) {
		String ids = read("D:\\workfile\\syncids\\supplier_price_ids");
		List<Long> idsList = new ArrayList<>();
		Arrays.asList(StringUtils.split(ids, "\r\n")).forEach(t -> idsList.add(Long.parseLong(t.trim())));
		int batchSize = idsList.size()/MAX_SIZE +1;
		logger.info("ids size:{},batchsize:{},detail:{}",idsList.size(),batchSize ,idsList);
		AtomicInteger batchNum = new AtomicInteger();
		while (idsList.size() > MAX_SIZE) {
			
			List<Long> idsSubList = idsList.subList(0, MAX_SIZE);
			String idsSub = StringUtils.join(idsSubList,",");
			int batchNumI = batchNum.incrementAndGet();
			logger.info("batchNum:{}/{} start,ids:{}",batchNumI,batchSize,idsSub);
			sync(batchNumI,batchSize,idsSub);
			idsList.removeAll(idsList.subList(0, MAX_SIZE));
			logger.info("batchNum:{}/{} end,ids:{}",batchNumI,batchSize,idsSub);
		}
		String idsSub = StringUtils.join(idsList,",");
		int batchNumI = batchNum.incrementAndGet();
		logger.info("batchNum:{}/{} start,ids:{}",batchNumI,batchSize,idsSub);
		sync(batchNumI,batchSize,idsSub);
		logger.info("batchNum:{}/{} end,ids:{}",batchNumI,batchSize,idsSub);
	}
	private static void sync(int batchNumI,int batchSize,String ids) {
		// get ids from localhost
		//1 update
		Map<String, Object> param  = new HashMap<String, Object>();
		param.put("appCode", "spmc-main");
		param.put("blockStrategy", "DISCARD_LATER");
		param.put("code", "手动重试采购数据同步");
		param.put("createBy", "82");
		param.put("createTime", null);
		param.put("dispatchExecutorStrategy", "ALL");
		param.put("dispatchExecutors", null);
		param.put("dispatchStrategy", "ROUND");
		param.put("handler", "com.sprucetec.price.spmc.pms.scheduler.ManualSyncPmsDataJob");
		param.put("id", 1145);
		param.put("language", "JAVA");
		param.put("lastClusterTime", null);
		param.put("maxRetryCount", 0);
		Map<String, String> paramTable = new HashMap<String, String>();
		paramTable.put("table","supplier_price");
		paramTable.put("ids",ids);
		param.put("params", JSON.toJSONString(paramTable));
		param.put("shardingTotal", 1);
		param.put("sourceCode", null);
		param.put("sourceCodeId", null);
		param.put("status", 1);
		param.put("triggers", null);
		param.put("type", "SIMPLE");
		param.put("updateBy", 333);
		param.put("updateTime", null);
		//2 execute
		String cookie = "gr_user_id=5a42fd54-f055-482f-8836-e4de7a8e2d7f; csrftoken=uQ9e05eWrAvt24DwZrzkiMJfgoqViZcP; product_schedule_principal=C/nnnbP828cZnchVJq0CNtfqZDaQ6paMhE5qp/D4gYNCP6INnKkoR86iBAW9NHjA17Ktn4e0bDAchOA4oHGOpMjsKZxf1jkr+eGLyEejpNIoKmglJBRkulVG/0O6tondElYccPaqhs6ERSqXX1cP3H56CnRUtAuIqq8MSzhrI9ykFLM/lTmVVKx0HqovuQeT126zlGaMWnqDH1Xjazo1BAUlOkOAc28MGRMe+8Ljm1r1DI77nt0VgwqPC9Uq+XVwNxCWtgsO0eUoOyx/4/k2r9dxWG80APD6II1vcUdTsTj6n7E2Ts2zvr8/IWQwXyqUYek0T9qHssasPUfS9hkaaBnmya/beijA; warehouseId=1; tms_site_currentSite=1; cityId=1; cis_current_city=1; tms_currentCity=1; test_tms_currentCity=1; stage_tms_currentCity=1; beta_user_token=admin_user_690560_web_d1d579833da334a2c1aff4a1e9b062d5; PRO_CASTGC=ldap; stage_user_token=admin_user_187571_web_2ac240a1bdbbdd044797b04272adeae2; STAGE_CASTGC=ldap";
		String resultUpdate = HttpUtil.doPostSSL("https://schedule.yunshanmeicai.com/job/update", param,cookie);
		logger.info("resultUpdate:{}/{},{},ids:{}",batchNumI,batchSize,resultUpdate,ids);
        String resultExecute = HttpUtil.doPostSSL("", "https://schedule.yunshanmeicai.com/job/trigger/1145",cookie);
        logger.info("resultExecute:{}/{},{},ids:{}",batchNumI,batchSize,resultExecute,ids);

	}
	
	private static String read(String path) {
		StringBuilder sb = new StringBuilder();
		try (Scanner scanner = new Scanner(Paths.get(path), StandardCharsets.UTF_8.toString())) {
			while (scanner.hasNextLine()) {
//				System.out.println(scanner.nextLine());
				sb.append(scanner.nextLine());
				sb.append("\n");
			}
			return sb.toString();
		} catch (IOException e) {
//			e.printStackTrace();
			return null;
		}
	}
}
