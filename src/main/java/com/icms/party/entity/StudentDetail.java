package com.icms.party.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class StudentDetail {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int Id;
		
		@Column(name = "course_id")
		private String CourseId;
		
		@Column(name = "gender")
		private String Gender;
		
		@Column(name = "score")
		private Long Score;
		
		@Column(name = "credits")
		private int Credits;

		
		
		public StudentDetail() {
			super();
		}

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public String getCourseId() {
			return CourseId;
		}

		public void setCourseId(String courseId) {
			CourseId = courseId;
		}

		public String getGender() {
			return Gender;
		}

		public void setGender(String gender) {
			Gender = gender;
		}

		public Long getScore() {
			return Score;
		}

		public void setScore(Long score) {
			Score = score;
		}

		public int getCredits() {
			return Credits;
		}

		public void setCredits(int credits) {
			Credits = credits;
		}

		@Override
		public String toString() {
			return "StudentDetail [Id=" + Id + ", CourseId=" + CourseId + ", Gender=" + Gender + ", Score=" + Score
					+ ", Credits=" + Credits + "]";
		}
		
		
		
}
