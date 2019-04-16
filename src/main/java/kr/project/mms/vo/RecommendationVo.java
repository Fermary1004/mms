package kr.project.mms.vo;

public class RecommendationVo {
	private Integer recommendation_id;
	private Integer recommended;
	private Integer recommender;
	
	public Integer getRecommendation_id() {
		return recommendation_id;
	}
	public void setRecommendation_id(Integer recommendation_id) {
		this.recommendation_id = recommendation_id;
	}
	public Integer getRecommended() {
		return recommended;
	}
	public void setRecommended(Integer recommended) {
		this.recommended = recommended;
	}
	public Integer getRecommender() {
		return recommender;
	}
	public void setRecommender(Integer recommender) {
		this.recommender = recommender;
	}
}
