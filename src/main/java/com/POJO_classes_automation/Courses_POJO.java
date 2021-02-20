package com.POJO_classes_automation;

import java.util.List;

// Child JSON
public class Courses_POJO {
		private List<WebAutomation_pojo> webautomation;// because it contains array of courseTitle & price
		private List<API_pojo> api;
		private List<Mobile_pojo> mobile;
		public List<WebAutomation_pojo> getWebautomation() {
			return webautomation;
		}
		public void setWebautomation(List<WebAutomation_pojo> webautomation) {
			this.webautomation = webautomation;
		}
		public List<API_pojo> getApi() {
			return api;
		}
		public void setApi(List<API_pojo> api) {
			this.api = api;
		}
		public List<Mobile_pojo> getMobile() {
			return mobile;
		}
		public void setMobile(List<Mobile_pojo> mobile) {
			this.mobile = mobile;
		}
		
		
		
		
}
