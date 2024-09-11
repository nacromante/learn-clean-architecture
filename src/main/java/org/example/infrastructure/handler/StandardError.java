package org.example.infrastructure.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandardError(Integer status, String message, String error, String path) {
		this.timestamp = System.currentTimeMillis();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

}