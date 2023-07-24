
-- 테이블 team_b.admin 구조 내보내기
CREATE TABLE IF NOT EXISTS `admin` (
    `iadmin` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `admin_Id` varchar(30) DEFAULT NULL,
    `admin_password` varchar(100) DEFAULT NULL,
    `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
    PRIMARY KEY (`iadmin`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.board 구조 내보내기
CREATE TABLE IF NOT EXISTS `board` (
    `iboard` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `iadmin` bigint(20) unsigned NOT NULL,
    `ctnt` text NOT NULL,
    `created_at` datetime DEFAULT current_timestamp(),
    `updated_at` datetime DEFAULT current_timestamp(),
    `importance` int(10) unsigned DEFAULT 0 CHECK (`importance` in (0,1)),
    `board_view` bigint(20) unsigned DEFAULT 0,
    `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
    `title` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`iboard`),
    KEY `iadmin` (`iadmin`),
    CONSTRAINT `board_ibfk_1` FOREIGN KEY (`iadmin`) REFERENCES `admin` (`iadmin`)
    ) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.lecture_applly 구조 내보내기
CREATE TABLE IF NOT EXISTS `lecture_applly` (
    `ilecture` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '강의신청pk',
    `ilecture_name` bigint(20) unsigned NOT NULL COMMENT '강의pk',
    `ilecture_room` bigint(20) unsigned NOT NULL COMMENT '강의실pk',
    `iprofessor` bigint(20) unsigned NOT NULL COMMENT '교수pk',
    `isemester` bigint(20) unsigned NOT NULL COMMENT '학기pk',
    `opening_procedures` tinyint(4) DEFAULT 1 COMMENT '개강절차(0,1,2,3)',
    `lecture_str_date` date DEFAULT NULL COMMENT '강의시작일',
    `lecture_end_date` date DEFAULT NULL COMMENT '강의종료일',
    `lecture_str_time` time DEFAULT NULL COMMENT '강의시작시간',
    `lecture_end_time` time DEFAULT NULL COMMENT '강의종료시간',
    `attendance` int(10) unsigned DEFAULT 20 COMMENT '출결',
    `midterm_examination` int(10) unsigned DEFAULT 40 COMMENT '중간고사',
    `final_examination` int(10) unsigned DEFAULT 40 COMMENT '기말고사',
    `lecture_max_people` int(10) unsigned NOT NULL COMMENT '강의최대인원',
    `grade_limit` int(10) unsigned NOT NULL COMMENT '학년범위',
    `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
    `created_at` datetime DEFAULT current_timestamp(),
    PRIMARY KEY (`ilecture`),
    KEY `ilecture_name` (`ilecture_name`),
    KEY `ilecture_room` (`ilecture_room`),
    KEY `iprofessor` (`iprofessor`),
    KEY `isemester` (`isemester`),
    CONSTRAINT `lecture_applly_ibfk_1` FOREIGN KEY (`ilecture_name`) REFERENCES `lecture_name` (`ilecture_name`),
    CONSTRAINT `lecture_applly_ibfk_2` FOREIGN KEY (`ilecture_room`) REFERENCES `lecture_room` (`ilecture_room`),
    CONSTRAINT `lecture_applly_ibfk_3` FOREIGN KEY (`iprofessor`) REFERENCES `professor` (`iprofessor`),
    CONSTRAINT `lecture_applly_ibfk_4` FOREIGN KEY (`isemester`) REFERENCES `semester` (`isemester`)
    ) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의 신청';

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.lecture_day_week 구조 내보내기
CREATE TABLE IF NOT EXISTS `lecture_day_week` (
    `ilecture` bigint(20) unsigned DEFAULT NULL COMMENT '강의신청pk',
    `day_week` int(11) NOT NULL COMMENT '강의요일',
    `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
    KEY `ilecture` (`ilecture`),
    CONSTRAINT `lecture_day_week_ibfk_1` FOREIGN KEY (`ilecture`) REFERENCES `lecture_applly` (`ilecture`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의 요일';

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.lecture_name 구조 내보내기
CREATE TABLE IF NOT EXISTS `lecture_name` (
    `ilecture_name` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '강의pk',
    `lecture_name` varchar(50) NOT NULL COMMENT '강의 이름',
    `score` int(10) unsigned NOT NULL COMMENT '학점',
    `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
    PRIMARY KEY (`ilecture_name`),
    UNIQUE KEY `lecture_name` (`lecture_name`)
    ) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의';

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.lecture_room 구조 내보내기
CREATE TABLE IF NOT EXISTS `lecture_room` (
    `ilecture_room` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '강의실pk',
    `lecture_room_name` varchar(50) NOT NULL COMMENT '강의실이름',
    `building_name` varchar(50) NOT NULL COMMENT '건물이름',
    `max_capacity` int(10) unsigned NOT NULL COMMENT '최대수용인원',
    `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
    PRIMARY KEY (`ilecture_room`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의실';

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.lecture_student 구조 내보내기
CREATE TABLE IF NOT EXISTS `lecture_student` (
    `ilecture_student` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `istudent` bigint(20) unsigned NOT NULL,
    `ilecture` bigint(20) unsigned NOT NULL,
    `finished_yn` int(10) unsigned DEFAULT 1 CHECK (`finished_yn` in (0,1,2)),
    `completed_at` date DEFAULT NULL,
    `attendance` int(10) unsigned NOT NULL,
    `midterm_examination` int(10) unsigned NOT NULL,
    `final_examination` int(10) unsigned NOT NULL,
    `total_score` int(10) unsigned NOT NULL,
    `avg_score` int(10) unsigned NOT NULL,
    `created_at` datetime DEFAULT current_timestamp(),
    `update_at` datetime DEFAULT current_timestamp(),
    `finished_at` date DEFAULT NULL,
    `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
    PRIMARY KEY (`ilecture_student`),
    KEY `istudent` (`istudent`),
    KEY `ilecture` (`ilecture`),
    CONSTRAINT `lecture_student_ibfk_1` FOREIGN KEY (`istudent`) REFERENCES `student` (`istudent`),
    CONSTRAINT `lecture_student_ibfk_2` FOREIGN KEY (`ilecture`) REFERENCES `lecture_applly` (`ilecture`)
    ) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.leture_condition 구조 내보내기
CREATE TABLE IF NOT EXISTS `leture_condition` (
    `ilecture` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '수강반려pk',
    `return_ctnt` text NOT NULL COMMENT '신청반려 내용',
    `return_date` datetime DEFAULT current_timestamp() COMMENT '반려일시',
    `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
    PRIMARY KEY (`ilecture`),
    CONSTRAINT `leture_condition_ibfk_1` FOREIGN KEY (`ilecture`) REFERENCES `lecture_applly` (`ilecture`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의 상태';

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.major 구조 내보내기
CREATE TABLE IF NOT EXISTS `major` (
    `imajor` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '전공pk',
    `major_name` varchar(50) NOT NULL COMMENT '전공이름',
    `graduation_score` int(10) unsigned NOT NULL COMMENT '졸업학점',
    `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
    PRIMARY KEY (`imajor`),
    UNIQUE KEY `major_name` (`major_name`)
    ) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='전공';

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.professor 구조 내보내기
CREATE TABLE IF NOT EXISTS `professor` (
    `iprofessor` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '교수pk',
    `imajor` bigint(20) unsigned NOT NULL COMMENT '전공pk',
    `professor_password` varchar(100) NOT NULL COMMENT '비밀번호',
    `nm` varchar(15) NOT NULL COMMENT '이름',
    `gender` char(1) NOT NULL COMMENT '성별',
    `pic` varchar(100) DEFAULT NULL COMMENT '사진',
    `birthdate` date NOT NULL COMMENT '생년월일',
    `phone` varchar(15) NOT NULL COMMENT '폰번호',
    `email` varchar(50) NOT NULL COMMENT '이메일',
    `address` varchar(100) NOT NULL COMMENT '주소',
    `created_at` datetime DEFAULT current_timestamp() COMMENT '생성일',
    `updated_at` datetime DEFAULT current_timestamp() COMMENT '수정일',
    `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
    PRIMARY KEY (`iprofessor`),
    UNIQUE KEY `email` (`email`),
    KEY `imajor` (`imajor`),
    CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`imajor`) REFERENCES `major` (`imajor`)
    ) ENGINE=InnoDB AUTO_INCREMENT=100031 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='교수프로필';

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.semester 구조 내보내기
CREATE TABLE IF NOT EXISTS `semester` (
    `isemester` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `year` year(4) DEFAULT year(current_timestamp()),
    `semester` int(10) unsigned NOT NULL,
    `semester_str_date` date DEFAULT NULL,
    `semester_end_date` date DEFAULT NULL,
    `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
    PRIMARY KEY (`isemester`),
    UNIQUE KEY `인덱스 2` (`year`,`semester`)
    ) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.student 구조 내보내기
CREATE TABLE IF NOT EXISTS `student` (
    `istudent` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `student_num` char(8) NOT NULL DEFAULT '',
    `student_password` varchar(100) NOT NULL,
    `imajor` bigint(20) unsigned NOT NULL,
    `grade` int(10) unsigned DEFAULT 1 CHECK (`grade` in (1,2,3,4)),
    `nm` varchar(15) NOT NULL,
    `gender` char(1) DEFAULT NULL CHECK (`gender` in ('F','M')),
    `pic` varchar(100) DEFAULT NULL,
    `birthdate` date NOT NULL,
    `phone` varchar(15) NOT NULL,
    `email` varchar(50) NOT NULL,
    `address` varchar(100) NOT NULL,
    `finished_yn` tinyint(5) DEFAULT 1 CHECK (`finished_yn` in (0,1,2,3)),
    `created_at` datetime DEFAULT current_timestamp(),
    `updated_at` datetime DEFAULT current_timestamp(),
    `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
    PRIMARY KEY (`istudent`),
    UNIQUE KEY `student_num` (`student_num`),
    UNIQUE KEY `email` (`email`),
    KEY `imajor` (`imajor`),
    CONSTRAINT `student_ibfk_1` FOREIGN KEY (`imajor`) REFERENCES `major` (`imajor`)
    ) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.student_semester_score 구조 내보내기
CREATE TABLE IF NOT EXISTS `student_semester_score` (
    `istudent` bigint(20) unsigned NOT NULL,
    `isemester` bigint(20) unsigned NOT NULL,
    `score` int(10) unsigned NOT NULL,
    `grade` int(10) unsigned NOT NULL,
    `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
    PRIMARY KEY (`istudent`,`isemester`),
    KEY `isemester` (`isemester`),
    CONSTRAINT `student_semester_score_ibfk_1` FOREIGN KEY (`istudent`) REFERENCES `student` (`istudent`),
    CONSTRAINT `student_semester_score_ibfk_2` FOREIGN KEY (`isemester`) REFERENCES `semester` (`isemester`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 team_b.token 구조 내보내기
CREATE TABLE IF NOT EXISTS `token` (
    `iuser` bigint(20) unsigned NOT NULL,
    `ip` varchar(15) NOT NULL,
    `access_token` varchar(200) NOT NULL,
    `refresh_token` varchar(200) NOT NULL,
    `created_at` datetime DEFAULT current_timestamp(),
    `updated_at` datetime DEFAULT current_timestamp(),
    `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
    PRIMARY KEY (`iuser`,`ip`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
