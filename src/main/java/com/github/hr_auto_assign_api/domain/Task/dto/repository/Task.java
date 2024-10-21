package com.github.hr_auto_assign_api.domain.Task.dto;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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
    @Column(name = "requirements")
    private List<String> requirements;  // 작업이 의존하는 이전 작업들

    // difficulty 값에 대한 커스텀 로직을 처리하는 setter
    public void setDifficulty(int difficulty) {
        if (difficulty < 1) {
            this.difficulty = difficulty * -1;  // 양수로 변환
        } else if (difficulty > 5) {
            this.difficulty = 3;  // 5 이상이면 기본값 3 설정
        } else {
            this.difficulty = difficulty;
        }
    }
}