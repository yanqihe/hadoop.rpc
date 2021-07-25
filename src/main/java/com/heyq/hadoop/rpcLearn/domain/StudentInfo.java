package com.heyq.hadoop.rpcLearn.domain;

import java.io.Serializable;

public class StudentInfo implements Serializable {
	private static final long serialVersionUID = -5204550722839137232L;

	private String studentId;
	private String name;

	public StudentInfo() {
		super();
	}

	private StudentInfo(Builder builder) {
		this.studentId = builder.studentId;
		this.name = builder.name;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentInfo other = (StudentInfo) obj;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentInfo [studentId=" + studentId + ", name=" + name + "]";
	}

	public static class Builder {
		private String studentId;
		private String name;

		public Builder setStudentId(String studentId) {
			this.studentId = studentId;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public StudentInfo builder() {
			return new StudentInfo(this);
		}

	}
}
