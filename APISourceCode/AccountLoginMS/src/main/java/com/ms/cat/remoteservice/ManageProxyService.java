package com.ms.cat.remoteservice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import com.ms.cat.config.YAMLConfig;
import com.ms.cat.dto.ManageProxyDTO;
import com.ms.cat.model.ManageProxyRepsonse;

@Component
public class ManageProxyService {


	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
    private YAMLConfig myConfig;
	

	public ManageProxyRepsonse addProxyDef(@RequestHeader("Authorization") String authorizationToken,@RequestBody ManageProxyDTO product) {
		
		return new ManageProxyRepsonse();
	}

	public ManageProxyDTO updateProxyDef(@RequestHeader("Authorization") String authorizationToken,@RequestBody ManageProxyDTO product) throws NODataFoundException
	{
		return new ManageProxyDTO();
	}

	public ManageProxyDTO[] getProxyDef(@RequestHeader("Authorization") String authorizationToken)
	{
		String url = myConfig.getAppProtocol() +"://" + myConfig.getAppIPAddress() + ":" + myConfig.getManageProxyMSPort() + "/proxydef/getProxyDef";
		System.out.println("Calling :" + url);
		ManageProxyDTO manageProxyDTO = null;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", authorizationToken);
		HttpEntity<ManageProxyDTO> dRequest = new HttpEntity<ManageProxyDTO>(manageProxyDTO,headers);
		ResponseEntity<ManageProxyDTO[]> dResponse = restTemplate.exchange(url, HttpMethod.GET, dRequest, ManageProxyDTO[].class);
		
		return dResponse.getBody();
	}

	public  List<ManageProxyDTO> getProxyDefById(@RequestHeader("Authorization") String authorizationToken,@PathVariable int id) throws NODataFoundException
	{
		ManageProxyDTO manageProxyDTO = new ManageProxyDTO("",String.valueOf(id),"");
		HttpEntity<ManageProxyDTO> dRequest = new HttpEntity<ManageProxyDTO>(manageProxyDTO);
		
		List<ManageProxyDTO> dResponse = (List<ManageProxyDTO>) restTemplate
				.postForEntity("http://discountms/caldisc", dRequest, ManageProxyDTO.class).getBody();
		return dResponse;
	}

	public String deleteProxyDef(@RequestHeader("Authorization") String authorizationToken,@PathVariable String name) throws NODataFoundException
	{
		return "";
	}

	


	/*
	@HystrixCommand(fallbackMethod = "discountFallback")
	public ProductDTO calculateDiscountv3(Product p) {
		DiscountRequest discountRequest = createDiscountRequest(p);
		HttpEntity<DiscountRequest> dRequest = new HttpEntity<DiscountRequest>(discountRequest);
		DiscountResponse dResponse = restTemplate
				.postForEntity("http://discountms/caldisc", dRequest, DiscountResponse.class).getBody();
		return ceateProductResponseDTO(dResponse, p);

	}*/

	



}
