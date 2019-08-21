
package com.kafka.model;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

	@JsonProperty("id")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String id;

	@JsonProperty("id_str")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String id_str;

	@JsonProperty("name")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String name;

	@JsonProperty("screen_name")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String screen_name;

	@JsonProperty("location")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String location;

	@JsonProperty("url")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String url;

	@JsonProperty("description")
	@MultiField(mainField = @Field(type = FieldType.Text, fielddata = true), otherFields = {
			@InnerField(suffix = "userdesckey", type = FieldType.Keyword, store = true) })
	private String description;
	
	@JsonProperty("translator_type")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String translator_type;
	
	@JsonProperty("verified")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean verified;
	
	@JsonProperty("followers_count")
	@Field(type = FieldType.Long, index = true, store = true)
	private Integer followers_count;
	
	@JsonProperty("friends_count")
	@Field(type = FieldType.Long, index = true, store = true) 
	private Integer friends_count;
	
	@JsonProperty("listed_count")
	@Field(type = FieldType.Long, index = true, store = true)
	private Integer listed_count;
	
	@JsonProperty("favourites_count")
	@Field(type = FieldType.Long, index = true, store = true)
	private Integer favourites_count;
	
	@JsonProperty("statuses_count")
	@Field(type = FieldType.Long, index = true, store = true)
	private Integer statuses_count;

	@JsonProperty("created_at")
	@Field(type = FieldType.Date, format = DateFormat.custom, index = true, store = true, pattern = "EEE MMM dd HH:mm:ss Z yyyy")
	private String created_at;
	
	@JsonProperty("utc_offset")
	@Field(type = FieldType.Object, index = true, store = true)
	private Object utc_offset;
	
	@JsonProperty("time_zone")
	@Field(type = FieldType.Object, index = true, store = true)
	private Object time_zone;
	
	@JsonProperty("geo_enabled")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean geo_enabled;
	
	@JsonProperty("lang")
	@Field(type = FieldType.Object, index = true, store = true)
	private Object lang;
	
	@JsonProperty("contributors_enabled")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean contributors_enabled;
	
	
	@JsonProperty("is_translator")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean is_translator;
	
	
	@JsonProperty("profile_background_image_url")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String profile_background_image_url;
	
	@JsonProperty("profile_background_image_url_https")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String profile_background_image_url_https;
	
	
	@JsonProperty("profile_background_tile")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean profile_background_tile;
	
	@JsonProperty("profile_use_background_image")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean profile_use_background_image;
	
	@JsonProperty("profile_image_url")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String profile_image_url;
	
	@JsonProperty("profile_image_url_https")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String profile_image_url_https;
	
	@JsonProperty("profile_banner_url")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String profile_banner_url;
	
	@JsonProperty("default_profile")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean default_profile;
	
	@JsonProperty("default_profile_image")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean default_profile_image;
	
	@JsonProperty("following")
	private Object following;
	@JsonProperty("notifications")
	private Object notifications;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_str() {
		return id_str;
	}

	public void setId_str(String id_str) {
		this.id_str = id_str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTranslator_type() {
		return translator_type;
	}

	public void setTranslator_type(String translator_type) {
		this.translator_type = translator_type;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Integer getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(Integer followers_count) {
		this.followers_count = followers_count;
	}

	public Integer getFriends_count() {
		return friends_count;
	}

	public void setFriends_count(Integer friends_count) {
		this.friends_count = friends_count;
	}

	public Integer getListed_count() {
		return listed_count;
	}

	public void setListed_count(Integer listed_count) {
		this.listed_count = listed_count;
	}

	public Integer getFavourites_count() {
		return favourites_count;
	}

	public void setFavourites_count(Integer favourites_count) {
		this.favourites_count = favourites_count;
	}

	public Integer getStatuses_count() {
		return statuses_count;
	}

	public void setStatuses_count(Integer statuses_count) {
		this.statuses_count = statuses_count;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public Object getUtc_offset() {
		return utc_offset;
	}

	public void setUtc_offset(Object utc_offset) {
		this.utc_offset = utc_offset;
	}

	public Object getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(Object time_zone) {
		this.time_zone = time_zone;
	}

	public Boolean getGeo_enabled() {
		return geo_enabled;
	}

	public void setGeo_enabled(Boolean geo_enabled) {
		this.geo_enabled = geo_enabled;
	}

	public Object getLang() {
		return lang;
	}

	public void setLang(Object lang) {
		this.lang = lang;
	}

	public Boolean getContributors_enabled() {
		return contributors_enabled;
	}

	public void setContributors_enabled(Boolean contributors_enabled) {
		this.contributors_enabled = contributors_enabled;
	}

	public Boolean getIs_translator() {
		return is_translator;
	}

	public void setIs_translator(Boolean is_translator) {
		this.is_translator = is_translator;
	}


	public String getProfile_background_image_url() {
		return profile_background_image_url;
	}

	public void setProfile_background_image_url(String profile_background_image_url) {
		this.profile_background_image_url = profile_background_image_url;
	}

	public String getProfile_background_image_url_https() {
		return profile_background_image_url_https;
	}

	public void setProfile_background_image_url_https(String profile_background_image_url_https) {
		this.profile_background_image_url_https = profile_background_image_url_https;
	}

	public Boolean getProfile_background_tile() {
		return profile_background_tile;
	}

	public void setProfile_background_tile(Boolean profile_background_tile) {
		this.profile_background_tile = profile_background_tile;
	}


	public Boolean getProfile_use_background_image() {
		return profile_use_background_image;
	}

	public void setProfile_use_background_image(Boolean profile_use_background_image) {
		this.profile_use_background_image = profile_use_background_image;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public String getProfile_image_url_https() {
		return profile_image_url_https;
	}

	public void setProfile_image_url_https(String profile_image_url_https) {
		this.profile_image_url_https = profile_image_url_https;
	}

	public String getProfile_banner_url() {
		return profile_banner_url;
	}

	public void setProfile_banner_url(String profile_banner_url) {
		this.profile_banner_url = profile_banner_url;
	}

	public Boolean getDefault_profile() {
		return default_profile;
	}

	public void setDefault_profile(Boolean default_profile) {
		this.default_profile = default_profile;
	}

	public Boolean getDefault_profile_image() {
		return default_profile_image;
	}

	public void setDefault_profile_image(Boolean default_profile_image) {
		this.default_profile_image = default_profile_image;
	}

	public Object getFollowing() {
		return following;
	}

	public void setFollowing(Object following) {
		this.following = following;
	}


	public Object getNotifications() {
		return notifications;
	}

	public void setNotifications(Object notifications) {
		this.notifications = notifications;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", id_str=" + id_str + ", name=" + name + ", screen_name=" + screen_name
				+ ", location=" + location + ", url=" + url + ", description=" + description + ", translator_type="
				+ translator_type + ", verified=" + verified + ", followers_count=" + followers_count
				+ ", friends_count=" + friends_count + ", listed_count=" + listed_count + ", favourites_count="
				+ favourites_count + ", statuses_count=" + statuses_count + ", created_at=" + created_at
				+ ", utc_offset=" + utc_offset + ", time_zone=" + time_zone + ", geo_enabled=" + geo_enabled + ", lang="
				+ lang + ", contributors_enabled=" + contributors_enabled + ", is_translator=" + is_translator
				+ ", profile_background_image_url=" + profile_background_image_url
				+ ", profile_background_image_url_https=" + profile_background_image_url_https
				+ ", profile_background_tile=" + profile_background_tile + ", profile_use_background_image="
				+ profile_use_background_image + ", profile_image_url=" + profile_image_url
				+ ", profile_image_url_https=" + profile_image_url_https + ", profile_banner_url=" + profile_banner_url
				+ ", default_profile=" + default_profile + ", default_profile_image=" + default_profile_image
				+ ", following=" + following + ", notifications=" + notifications + "]";
	}


}
