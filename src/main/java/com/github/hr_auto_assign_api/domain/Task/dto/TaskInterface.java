package com.github.hr_auto_assign_api.domain.Task.dto;

import java.util.List;

interface TaskInterface {
    String getName();
    List<String> getEmployees();
    int getDifficulty();
    List<String> getRequirements();
}

