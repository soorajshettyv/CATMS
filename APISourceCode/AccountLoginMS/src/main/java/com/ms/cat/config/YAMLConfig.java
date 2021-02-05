package com.ms.cat.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
 
    private String appProtocol;
    private String appIPAddress;
    private String manageProxyMSPort;
    private String manageProxyMSName;
    
	public String getAppProtocol() {
		return appProtocol;
	}
	public void setAppProtocol(String appProtocol) {
		this.appProtocol = appProtocol;
	}
	public String getAppIPAddress() {
		return appIPAddress;
	}
	public void setAppIPAddress(String appIPAddress) {
		this.appIPAddress = appIPAddress;
	}
	public String getManageProxyMSPort() {
		return manageProxyMSPort;
	}
	public void setManageProxyMSPort(String manageProxyMSPort) {
		this.manageProxyMSPort = manageProxyMSPort;
	}
	public String getManageProxyMSName() {
		return manageProxyMSName;
	}
	public void setManageProxyMSName(String manageProxyMSName) {
		this.manageProxyMSName = manageProxyMSName;
	}
    



}