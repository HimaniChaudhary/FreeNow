package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * This builder class is wrapper on rest assured api.
 * 
 */
public class RequestBuilder {

	private HashMap<String, String> headers;
	private HashMap<String, String> params;

	private String endPoint;
	private Object request;

	// GET call
	public Response executeGet() {
		RequestSpecification request = RestAssured.given().when().with();
		if (this.getEndPoint() != null) {
			if (this.getHeaders() != null) {
				request = request.headers(getHeaders());
			}
			if (this.getParams() != null) {
				request = request.params(getParams());
			}
			if (this.getRequestBody() != null) {
				request = request.body(getRequestBody());
			}
			return request.get(getEndPoint());
		}
		return null;
	}

	// POST call 
	public Response executePost() {

		RequestSpecification request = RestAssured.given().when().with().contentType("application/json");
		if (this.getEndPoint() != null && this.getRequestBody() != null) {
			if (this.getHeaders() != null) {
				request = request.headers(getHeaders());
			}

			Logger logger = Logger.getLogger("RequestBuilder");
			logger.info("Executing Post Endpoint : " + getEndPoint());
			return request.body(getRequestBody()).post(getEndPoint());
		}
		return null;
	}

	// PUT call
	public Response executePut() {
		RequestSpecification request = RestAssured.given().when().with().contentType("application/json");
		if (this.getEndPoint() != null && this.getRequestBody() != null) {
			if (this.getHeaders() != null) {
				request = request.headers(getHeaders());
			}

			Logger logger = Logger.getLogger("RequestBuilder");
			logger.info("Executing Put Endpoint : " + getEndPoint());

			return request.body(getRequestBody()).put(getEndPoint());
		}
		return null;
	}

	// DELETE call
	public Response executeDelete() {
		RequestSpecification request = RestAssured.given().when().with().contentType("application/json");
		if (this.getEndPoint() != null && this.getRequestBody() != null) {
			if (this.getHeaders() != null) {
				request = request.headers(getHeaders());
			}

			Logger logger = Logger.getLogger("RequestBuilder");
			logger.info("Executing Delete Endpoint : " + getEndPoint());

			return request.body(getRequestBody()).delete(getEndPoint());
		}
		return null;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public HashMap<String, String> getHeaders() {
		return headers;
	}

	public HashMap<String, String> getParams() {
		return params;
	}

	public Object getRequestBody() {
		return request;
	}

	public RequestBuilder setEndPoint(String endPoint) {
		this.endPoint = endPoint;
		return this;
	}

	public RequestBuilder setHeaders(Map<String, String> map) {
		this.headers = (HashMap<String, String>) map;
		return this;
	}

	public RequestBuilder setParams(HashMap<String, String> params) {
		this.params = params;
		return this;
	}

	public RequestBuilder setRequestBody(Object request) {
		this.request = request;
		return this;
	}

}