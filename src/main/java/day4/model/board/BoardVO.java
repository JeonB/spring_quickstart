package day4.model.board;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

//VO(Value Object)
@Getter
@Setter
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
}