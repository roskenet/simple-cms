package de.roskenet.simplecms.api;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

class ApiPage {
	@JsonProperty("id")
	String id;
	@JsonProperty("path")
	String path;
	@JsonProperty("tags")
	Set<String> tags = new HashSet<>();
	@JsonProperty("author")
	String owner;
	@JsonProperty("category")
	String category;
}
