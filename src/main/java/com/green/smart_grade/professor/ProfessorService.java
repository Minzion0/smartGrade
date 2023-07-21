package com.green.smart_grade.professor;

import com.green.smart_grade.professor.model.*;
import com.green.smart_grade.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorMapper mapper;
    private final CommonUtils commonUtils;




    public List<ProfessorVo> selProfessor(ProfessorSelDto dto) {
        int startIdx = (dto.getPage() - 1) * dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.selProfessor(dto);
    }


    public int upProfessorPw(ProfessorUpPW dto) {
        String hashedPw = commonUtils.encodeSha256(dto.getPassword());
        dto.setPassword(hashedPw);
        return mapper.upProfessorPw(dto);
    }

    public int selProfessorById(ProfessorLoginDto dto) {
        ProfessorLoginVo vo = mapper.selProfessorByUid(dto);
        if(vo == null) { return 2; }
        String hashedPw = commonUtils.encodeSha256(dto.getPassword());
        if(vo.getPassword().equals(hashedPw)) {
            return 1;
        }
        return 3;
    }


    public ProfessorInsRes upProfessor(ProfessorParam param) {
        ProfessorUpDto dto = new ProfessorUpDto();
        dto.setPassword(param.getPassword());
        dto.setPhone(param.getPhone());
        dto.setEmail(param.getEmail());
        dto.setAddress(param.getAddress());


        int result = mapper.upProfessor(dto);
        if (result == 1 ) {
            return new ProfessorInsRes(dto);
        }
        return null;
    }


}
