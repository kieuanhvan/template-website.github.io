package BEAN;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportV2 {
	@Id
	private String Group;
	
	private Long Likes;
	
	private Date NewDate;
	
	private Date OldDate;

	
	public ReportV2() {
		super();
	}

	public  ReportV2(String group, Long likes, Date newDate, Date oldDate) {
		Group = group;
		Likes = likes;
		NewDate = newDate;
		OldDate = oldDate;
	}

	public Serializable getGroup() {
		return Group;
	}

	public void setGroup(String group) {
		Group = group;
	}

	public Long getLikes() {
		return Likes;
	}

	public void setLikes(Long likes) {
		Likes = likes;
	}

	public Date getNewDate() {
		return NewDate;
	}

	public void setNewDate(Date newDate) {
		NewDate = newDate;
	}

	public Date getOldDate() {
		return OldDate;
	}

	public void setOldDate(Date oldDate) {
		OldDate = oldDate;
	}

	@Override
	public String toString() {
		return "Report [Group=" + Group + ", Likes=" + Likes + ", NewDate=" + NewDate + ", OldDate=" + OldDate + "]";
	}
	
	
	
}
