
package com.kafka.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "created_at", "id", "id_str", "text", "source", "truncated", "user", "geo", "coordinates", "place",
		"contributors", "retweeted_status", "quoted_status_id", "quoted_status_id_str", "is_quote_status",
		"quote_count", "reply_count", "retweet_count", "favorite_count", "favorited", "retweeted", "possibly_sensitive",
		"filter_level", "lang", "timestamp_ms" })
@Document(indexName = "twitter", type = "tweets")
public class Tweet {

	@JsonProperty("created_at")
	@Field(type = FieldType.Date, format = DateFormat.custom, index = true, store = true, pattern = "EEE MMM dd HH:mm:ss Z yyyy")
	private String created_at;

	@JsonProperty("id")
	@Id
	private String id;

	@JsonProperty("id_str")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String id_str;

	@JsonProperty("text")
	@MultiField(mainField = @Field(type = FieldType.Text, fielddata = true), otherFields = {
			@InnerField(suffix = "textkey", index = true, type = FieldType.Keyword, store = true) })
	private String text;

	@JsonProperty("source")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String source;

	// copyTo property is used for combining 2 or more field combined in to third
	// field
	//Fields that are not indexed are not queryable
	//By default, field values are indexed to make them searchable, but they are not stored. This means that the field can be queried, 
	//but the original field value cannot be retrieved.

	@JsonProperty("truncated")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean truncated;

	@JsonProperty("user")
	@Field(type = FieldType.Object,  index = true, store = true)
	private User user;

	@JsonProperty("geo")
	@Field(type = FieldType.Object, includeInParent = true, index = true, store = true)
	private Object geo;
	
	@JsonProperty("coordinates")
	@Field(type = FieldType.Object, includeInParent = true, index = true, store = true)
	private Object coordinates;
	
	@JsonProperty("place")
	@Field(type = FieldType.Object, includeInParent = true, index = true, store = true)
	private Object place;
	
	@JsonProperty("contributors")
	@Field(type = FieldType.Object, includeInParent = true, index = true, store = true)
	private Object contributors;
	
	@JsonProperty("quoted_status_id")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String quoted_status_id;
	
	@JsonProperty("quoted_status_id_str")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String quoted_status_id_str;
	
	@JsonProperty("is_quote_status")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean is_quote_status;
	
	@JsonProperty("quote_count")
	@Field(type = FieldType.Long, index = true, store = true)
	private String quote_count;
	
	@JsonProperty("reply_count")
	@Field(type = FieldType.Long, index = true, store = true)
	private String reply_count;
	
	@JsonProperty("retweet_count")
	@Field(type = FieldType.Long, index = true, store = true)
	private String retweet_count;
	
	@JsonProperty("favorite_count")
	@Field(type = FieldType.Long, index = true, store = true)
	private String favorite_count;
	
	@JsonProperty("favorited")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean favorited;
	
	@JsonProperty("retweeted")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean retweeted;
	
	@JsonProperty("possibly_sensitive")
	@Field(type = FieldType.Boolean, index = true, store = true)
	private Boolean possibly_sensitive;
	
	@JsonProperty("filter_level")
	@Field(type = FieldType.Keyword, index = true, store = true)
	private String filter_level;
	@JsonProperty("lang")
	@MultiField(mainField = @Field(type = FieldType.Text, fielddata = true), otherFields = {
			@InnerField(suffix = "langkey", type = FieldType.Keyword, store = true) })
	private String lang;
	
	
	@JsonProperty("timestamp_ms")
	@Field(type = FieldType.Date, format = DateFormat.custom, index = true, store = true,pattern="yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
	private String timestamp_ms;

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Boolean getTruncated() {
		return truncated;
	}

	public void setTruncated(Boolean truncated) {
		this.truncated = truncated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Object getGeo() {
		return geo;
	}

	public void setGeo(Object geo) {
		this.geo = geo;
	}

	public Object getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Object coordinates) {
		this.coordinates = coordinates;
	}

	public Object getPlace() {
		return place;
	}

	public void setPlace(Object place) {
		this.place = place;
	}

	public Object getContributors() {
		return contributors;
	}

	public void setContributors(Object contributors) {
		this.contributors = contributors;
	}

	public String getQuoted_status_id() {
		return quoted_status_id;
	}

	public void setQuoted_status_id(String quoted_status_id) {
		this.quoted_status_id = quoted_status_id;
	}

	public String getQuoted_status_id_str() {
		return quoted_status_id_str;
	}

	public void setQuoted_status_id_str(String quoted_status_id_str) {
		this.quoted_status_id_str = quoted_status_id_str;
	}

	public Boolean getIs_quote_status() {
		return is_quote_status;
	}

	public void setIs_quote_status(Boolean is_quote_status) {
		this.is_quote_status = is_quote_status;
	}

	public String getQuote_count() {
		return quote_count;
	}

	public void setQuote_count(String quote_count) {
		this.quote_count = quote_count;
	}

	public String getReply_count() {
		return reply_count;
	}

	public void setReply_count(String reply_count) {
		this.reply_count = reply_count;
	}

	public String getRetweet_count() {
		return retweet_count;
	}

	public void setRetweet_count(String retweet_count) {
		this.retweet_count = retweet_count;
	}

	public String getFavorite_count() {
		return favorite_count;
	}

	public void setFavorite_count(String favorite_count) {
		this.favorite_count = favorite_count;
	}

	public Boolean getFavorited() {
		return favorited;
	}

	public void setFavorited(Boolean favorited) {
		this.favorited = favorited;
	}

	public Boolean getRetweeted() {
		return retweeted;
	}

	public void setRetweeted(Boolean retweeted) {
		this.retweeted = retweeted;
	}

	public Boolean getPossibly_sensitive() {
		return possibly_sensitive;
	}

	public void setPossibly_sensitive(Boolean possibly_sensitive) {
		this.possibly_sensitive = possibly_sensitive;
	}

	public String getFilter_level() {
		return filter_level;
	}

	public void setFilter_level(String filter_level) {
		this.filter_level = filter_level;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getTimestamp_ms() {
		return timestamp_ms;
	}

	public void setTimestamp_ms(String timestamp_ms) {
		this.timestamp_ms = timestamp_ms;
	}

	@Override
	public String toString() {
		return "Tweet [created_at=" + created_at + ", id=" + id + ", id_str=" + id_str + ", text=" + text + ", source="
				+ source + ", truncated=" + truncated + ", user=" + user + ", geo=" + geo + ", coordinates="
				+ coordinates + ", place=" + place + ", contributors=" + contributors + ", quoted_status_id="
				+ quoted_status_id + ", quoted_status_id_str=" + quoted_status_id_str + ", is_quote_status="
				+ is_quote_status + ", quote_count=" + quote_count + ", reply_count=" + reply_count + ", retweet_count="
				+ retweet_count + ", favorite_count=" + favorite_count + ", favorited=" + favorited + ", retweeted="
				+ retweeted + ", possibly_sensitive=" + possibly_sensitive + ", filter_level=" + filter_level
				+ ", lang=" + lang + ", timestamp_ms=" + timestamp_ms + "]";
	}

}
