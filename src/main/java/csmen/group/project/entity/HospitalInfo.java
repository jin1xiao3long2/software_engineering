package csmen.group.project.entity;

public class HospitalInfo {
		private int HID;
		private String hos_name;
		private String province;
		private String city;
		private String introduction;
		private String classifier;
		private String address;
		
		public int getHID() {
			return HID;
		}
		public void setHID(int hID) {
			HID = hID;
		}
		public String getHos_name() {
			return hos_name;
		}
		public void setHos_name(String hos_name) {
			this.hos_name = hos_name;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getIntroduction() {
			return introduction;
		}
		public void setIntroduction(String introduction) {
			this.introduction = introduction;
		}
		public String getClassifier() {
			return this.classifier;
		}
		public void setClassifier(String classifier) {
			this.classifier = classifier;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		public HospitalInfo()
		{
			
		}
		
		public HospitalInfo(int HID, String hos_name, String province, String city, String introduction, String classifier, String address)
		{
			this.HID = HID;
			this.hos_name = hos_name;
			this.province = province;
			this.city = city;
			this.introduction = introduction;
			this.classifier = classifier;
			this.address = address;
		}
}
