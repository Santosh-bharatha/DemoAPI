package com.streams.demo;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomCourseDemo {
	
public static void main(String[] args) {
		
		List<Course> courses = 
		List.of(new Course("Spring","Java",95,20000),
				new Course(".Net","MSoft",60,20000),
				new Course("AWS","Cloud",94,20000),
				new Course("Azure","MSoft",90,20000),
				new Course("FullStack","Java",90,20000),
				new Course("Docker","Cloud",80,20000),
				new Course("Kubernetis","Cloud",96,20000));
	
		
		//AllMatch, None-Match, any-Match
		Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore()>50;
		System.out.println("Review Score above 95 AllMatch:: "+courses.stream().allMatch(reviewScoreGreaterThan95));
		
		Predicate<Course> reviewScoreGreaterThan90 = course -> course.getReviewScore() >90;
		System.out.println("Review Score above 95 None match:: "+courses.stream().noneMatch(reviewScoreGreaterThan95));
		
		
		System.out.println("Review Score above 95 Any match:: "+courses.stream().anyMatch(reviewScoreGreaterThan95));
		
		
		System.out.println(courses.stream().takeWhile(course ->course.getReviewScore() >=95).collect(Collectors.toList()));
		System.out.println(courses.stream().dropWhile(course ->course.getReviewScore() >=95).collect(Collectors.toList()));
		
		Comparator<Course> comparingByNoOfStudentsAndReviews = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore).reversed();

		System.out.println(courses.stream().max(comparingByNoOfStudentsAndReviews));
		System.out.println(courses.stream().filter(reviewScoreGreaterThan90).min(comparingByNoOfStudentsAndReviews).orElse(new Course("Kubernetis","Cloud",96,20000)));
		System.out.println(courses.stream().filter(reviewScoreGreaterThan90).findFirst());
		System.out.println(courses.stream().filter(reviewScoreGreaterThan90).findAny());
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95).mapToInt(Course::getNoOfStudents).sum());
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95).mapToInt(Course::getNoOfStudents).average());
		
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		System.out.println(courses.stream().
				collect(Collectors.groupingBy(Course::getCategory, 
						Collectors.mapping(Course::getName, Collectors.toList()))));
		
	}
}


class Course{
	
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudents="
				+ noOfStudents + "]";
	}
		
}