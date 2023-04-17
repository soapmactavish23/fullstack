package br.hkprogrammer.fullstack.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class StandartError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Instant timestemp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandartError() {

	}

	public StandartError(Instant timestemp, Integer status, String error, String message, String path) {
		super();
		this.timestemp = timestemp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestemp() {
		return timestemp;
	}

	public void setTimestemp(Instant timestemp) {
		this.timestemp = timestemp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public int hashCode() {
		return Objects.hash(error, message, path, status, timestemp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StandartError other = (StandartError) obj;
		return Objects.equals(error, other.error) && Objects.equals(message, other.message)
				&& Objects.equals(path, other.path) && Objects.equals(status, other.status)
				&& Objects.equals(timestemp, other.timestemp);
	}

	@Override
	public String toString() {
		return "StandartError [timestemp=" + timestemp + ", status=" + status + ", error=" + error + ", message="
				+ message + ", path=" + path + "]";
	}
	
}
