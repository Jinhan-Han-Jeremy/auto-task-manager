package com.github.hr_auto_assign_api.domain.TaskHistory.dto;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Entity
@Table(name = "tasks_history")
@Data // Lombok을 사용하여 getter, setter, toString, equals, hashCode 등을 자동 생성
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 사용하는 생성자
@Builder // 빌더 패턴으로 객체 생성 가능
public class TasksHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 생성
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "task_team_members", joinColumns = @JoinColumn(name = "tasks_history_id"))
    @Column(name = "teammembers")
    private List<String> teamMembers;

    @ElementCollection
    @CollectionTable(name = "task_available_jobs", joinColumns = @JoinColumn(name = "tasks_history_id"))
    @Column(name = "available_jobs")
    private List<String> availableJobs;

    @Column(name = "spending_days")
    private int spendingDays;

    @Column(name = "state")
    private String state;

    @Column(name = "requirements_satisfied")
    private boolean requirementsSatisfied;

}