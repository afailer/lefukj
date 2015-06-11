package com.lefukj.health.bean;

import java.io.File;

public class UpdateInfo {

	private String version;
	private String apkUrl;
	private String desc;

	public UpdateInfo() {
		super();
	}

	public UpdateInfo(String version, String apkUrl, String desc) {
		super();
		this.version = version;
		this.apkUrl = apkUrl;
		this.desc = desc;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getApkUrl() {
		return apkUrl;
	}

	public void setApkUrl(String apkUrl) {
		this.apkUrl = apkUrl;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
