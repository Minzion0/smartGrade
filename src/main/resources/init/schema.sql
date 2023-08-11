set foreign_key_checks = 0;

drop table if EXISTS `admin`;

CREATE TABLE IF NOT EXISTS admin (
  `iadmin` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `admin_Id` varchar(30) DEFAULT NULL,
  `admin_password` varchar(100) DEFAULT NULL,
  `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
  `role` varchar(30) DEFAULT 'ROLE_ADMIN',
  `secret_key` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`iadmin`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

drop table if EXISTS `board`;

CREATE TABLE IF NOT EXISTS board (
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

drop table if EXISTS board_pics;

CREATE TABLE IF NOT EXISTS board_pics (
  `ipic` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `iboard` bigint(20) unsigned NOT NULL,
  `pic` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ipic`),
  KEY `iboard` (`iboard`),
  CONSTRAINT `board_pics_ibfk_1` FOREIGN KEY (`iboard`) REFERENCES `board` (`iboard`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

drop table if EXISTS lecture_name;

CREATE TABLE IF NOT EXISTS lecture_name (
  `ilecture_name` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '강의pk',
  `lecture_name` varchar(50) NOT NULL COMMENT '강의 이름',
  `score` int(10) unsigned NOT NULL COMMENT '학점',
  `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
  PRIMARY KEY (`ilecture_name`),
  UNIQUE KEY `lecture_name` (`lecture_name`)
  ) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의';


drop table if EXISTS major;

CREATE TABLE IF NOT EXISTS major (
  `imajor` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '전공pk',
  `major_name` varchar(50) NOT NULL COMMENT '전공이름',
  `graduation_score` int(10) unsigned NOT NULL COMMENT '졸업학점',
  `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
  `remarks` varchar(50) DEFAULT ' ' COMMENT '비고',
  PRIMARY KEY (`imajor`),
  UNIQUE KEY `major_name` (`major_name`)
  ) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='전공';

drop table if EXISTS professor;

CREATE TABLE IF NOT EXISTS professor (
  `iprofessor` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '교수pk',
  `imajor` bigint(20) unsigned NOT NULL COMMENT '전공pk',
  `professor_password` varchar(100) NOT NULL COMMENT '비밀번호',
  `nm` varchar(15) NOT NULL COMMENT '이름',
  `gender` char(1) NOT NULL COMMENT '성별',
  `pic` varchar(100) DEFAULT NULL COMMENT '사진',
  `birthdate` date NOT NULL COMMENT '생년월일',
  `phone` varchar(15) NOT NULL COMMENT '폰번호',
  `email` varchar(50) DEFAULT NULL COMMENT '이메일',
  `address` varchar(100) DEFAULT NULL COMMENT '주소',
  `created_at` datetime DEFAULT current_timestamp() COMMENT '생성일',
  `updated_at` datetime DEFAULT current_timestamp() COMMENT '수정일',
  `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
  `role` varchar(30) NOT NULL DEFAULT 'ROLE_PROFESSOR',
  `secret_key` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`iprofessor`),
  UNIQUE KEY `email` (`email`),
  KEY `imajor` (`imajor`),
  CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`imajor`) REFERENCES `major` (`imajor`)
  ) ENGINE=InnoDB AUTO_INCREMENT=100046 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='교수프로필';

drop table if EXISTS semester;

CREATE TABLE IF NOT EXISTS semester (
  `isemester` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `year` year(4) DEFAULT year(current_timestamp()),
  `semester` int(10) unsigned NOT NULL,
  `semester_str_date` date NOT NULL,
  `semester_end_date` date NOT NULL,
  `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
  PRIMARY KEY (`isemester`),
  UNIQUE KEY  (`year`,`semester`)
  ) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;






drop table if EXISTS student;



CREATE TABLE IF NOT EXISTS student (
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
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `finished_yn` tinyint(5) DEFAULT 1 CHECK (`finished_yn` in (0,1,2,3)),
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
  `role` varchar(30) DEFAULT 'ROLE_STUDENT',
  `secret_key` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`istudent`),
  UNIQUE KEY `student_num` (`student_num`),
  UNIQUE KEY `email` (`email`),
  KEY `imajor` (`imajor`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`imajor`) REFERENCES `major` (`imajor`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


drop table if EXISTS student_semester_score;


CREATE TABLE IF NOT EXISTS student_semester_score (
  `istudent` bigint(20) unsigned NOT NULL,
  `isemester` bigint(20) unsigned NOT NULL,
  `score` int(10) unsigned NOT NULL,
  `grade` int(10) unsigned NOT NULL,
  `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
  `avg_score` int(10) unsigned DEFAULT NULL COMMENT '평균점수',
  `rating` double unsigned DEFAULT NULL COMMENT '평점',
  PRIMARY KEY (`istudent`,`isemester`),
  UNIQUE KEY (`istudent`,`isemester`),
  KEY `isemester` (`isemester`),
  CONSTRAINT `student_semester_score_ibfk_1` FOREIGN KEY (`istudent`) REFERENCES `student` (`istudent`),
  CONSTRAINT `student_semester_score_ibfk_2` FOREIGN KEY (`isemester`) REFERENCES `semester` (`isemester`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


drop table if EXISTS user_token;

CREATE TABLE IF NOT EXISTS user_token (
  `iuser` bigint(20) unsigned NOT NULL,
  `ip` varchar(15) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `role` varchar(30) NOT NULL,
  PRIMARY KEY (`iuser`,`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

drop table if EXISTS lecture_applly;

CREATE TABLE IF NOT EXISTS lecture_applly (
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
  ) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의 신청';

drop table if EXISTS lecture_day_week;

CREATE TABLE IF NOT EXISTS lecture_day_week (
  `ilecture` bigint(20) unsigned DEFAULT NULL COMMENT '강의신청pk',
  `day_week` int(11) NOT NULL DEFAULT 0 COMMENT '강의요일',
  `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
  KEY `ilecture` (`ilecture`),
  CONSTRAINT `lecture_day_week_ibfk_1` FOREIGN KEY (`ilecture`) REFERENCES `lecture_applly` (`ilecture`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의 요일';

drop table if EXISTS lecture_student;

CREATE TABLE IF NOT EXISTS lecture_student (
  `ilecture_student` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `istudent` bigint(20) unsigned NOT NULL,
  `ilecture` bigint(20) unsigned NOT NULL,
  `finished_yn` int(10) unsigned NOT NULL DEFAULT 1,
  `attendance` int(10) unsigned NOT NULL DEFAULT 0,
  `midterm_examination` int(10) unsigned NOT NULL DEFAULT 0,
  `final_examination` int(10) unsigned NOT NULL DEFAULT 0,
  `total_score` int(10) unsigned NOT NULL DEFAULT 0,
  `created_at` datetime DEFAULT current_timestamp() COMMENT '처음 인서트한날 0점',
  `update_at` datetime DEFAULT current_timestamp() COMMENT '성적 넣은 날',
  `finished_at` date DEFAULT NULL COMMENT '수강 완료 날',
  `correction_at` datetime DEFAULT NULL COMMENT '2주간 정정기간 날짜 기준',
  `del_yn` int(10) unsigned DEFAULT 0 CHECK (`del_yn` in (0,1)),
  PRIMARY KEY (`ilecture_student`),
  UNIQUE KEY (`istudent`,`ilecture`),
  KEY `ilecture` (`ilecture`),
  CONSTRAINT `lecture_student_ibfk_1` FOREIGN KEY (`istudent`) REFERENCES `student` (`istudent`),
  CONSTRAINT `lecture_student_ibfk_2` FOREIGN KEY (`ilecture`) REFERENCES `lecture_applly` (`ilecture`)
  ) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

drop table if EXISTS lecture_day_week;

CREATE TABLE IF NOT EXISTS lecture_day_week (
  `ilecture` bigint(20) unsigned DEFAULT NULL COMMENT '강의신청pk',
  `day_week` int(11) NOT NULL DEFAULT 0 COMMENT '강의요일',
  `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
  KEY `ilecture` (`ilecture`),
  CONSTRAINT `lecture_day_week_ibfk_1` FOREIGN KEY (`ilecture`) REFERENCES `lecture_applly` (`ilecture`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의 요일';

drop table if EXISTS lecture_room;

CREATE TABLE IF NOT EXISTS lecture_room (
  `ilecture_room` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '강의실pk',
  `lecture_room_name` varchar(50) NOT NULL COMMENT '강의실이름',
  `building_name` varchar(50) NOT NULL COMMENT '건물이름',
  `max_capacity` int(10) unsigned NOT NULL COMMENT '최대수용인원',
  `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
  PRIMARY KEY (`ilecture_room`)
  ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의실';

drop table if EXISTS leture_condition;

CREATE TABLE IF NOT EXISTS `leture_condition` (
  `ilecture` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '수강반려pk',
  `return_ctnt` text NOT NULL COMMENT '신청반려 내용',
  `return_date` datetime DEFAULT current_timestamp() COMMENT '반려일시',
  `del_yn` int(10) unsigned DEFAULT 0 COMMENT '삭제여부',
  PRIMARY KEY (`ilecture`),
  CONSTRAINT `leture_condition_ibfk_1` FOREIGN KEY (`ilecture`) REFERENCES `lecture_applly` (`ilecture`)
  ) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의 상태';


set foreign_key_checks = 1;