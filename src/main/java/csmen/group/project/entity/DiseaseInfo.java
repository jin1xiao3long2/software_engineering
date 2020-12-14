package csmen.group.project.entity;

public class DiseaseInfo {
		private String name;
		private String distinguish;
		private String reason;
		private String symptom;
		private String heal;
		private String alias;
		
		public DiseaseInfo()
		{
			
		}
		
		public DiseaseInfo(String name, String distinguish, String reason, String symptom, String heal, String alias)
		{
			this.name = name;
			this.distinguish = distinguish;
			this.reason = reason;
			this.symptom = symptom;
			this.heal = heal;
			this.alias = alias;
		}
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDistinguish() {
			return distinguish;
		}
		public void setDistinguish(String distinguish) {
			this.distinguish = distinguish;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public String getSymptom() {
			return symptom;
		}
		public void setSymptom(String symptom) {
			this.symptom = symptom;
		}
		public String getHeal() {
			return heal;
		}
		public void setHeal(String heal) {
			this.heal = heal;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		
		
}
