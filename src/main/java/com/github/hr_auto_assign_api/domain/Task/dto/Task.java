package com.github.hr_auto_assign_api.domain.Task.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tasks")
public class Task implements TaskInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;  // 작업 이름

    @ElementCollection
    @CollectionTable(name = "task_employees", joinColumns = @JoinColumn(name = "task_id"))
    @Column(name = "employees")
    private List<String> employees;  // 작업을 수행할 수 있는 직원들의 역할

    @Column(name = "difficulty", nullable = false)
    private int difficulty;  // 작업 난이도

    @ElementCollection
    @CollectionTable(name = "task_requirements", joinColumns = @JoinColumn(name = "task_id"))
    @Column(name = "requirement")
    private List<String> requirements;  // 작업이 의존하는 이전 작업들

    // 모든 필드를 포함하는 생성자
    public Task(String name, List<String> employees, int difficulty, List<String> requirements) {
        this.name = name;
        this.employees = employees;
        setDifficulty(difficulty);
        this.requirements = requirements;
    }

    // getter 메서드
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getEmployees() {
        return employees;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    // setter 메서드
    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }

    public void setDifficulty(int difficulty) {
        if (difficulty < 1) {
            this.difficulty = difficulty * -1;
        } else if (difficulty > 5) {
            this.difficulty = 3;
        } else {
            this.difficulty = difficulty;
        }
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }
}