package com.green.smartGrade.professor.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProfessoreDatailProFileVo {
    List<ProfessorMajor> lectureList;
    ProfessorDatilProfile profile;



}
