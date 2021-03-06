package com.hackerda.platform.infrastructure.database.model.example;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TeacherCourseTimetable {
    private Integer id;

    private Integer courseTimetableId;

    private Integer teacherId;

    private String termYear;

    private Integer termOrder;

}