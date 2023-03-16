package BEAN;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Report {
	@Id
	private Serializable Group;
	
	private Long Likes;
	
	private Date NewDate;
	
	private Date OldDate;

	public Report(Serializable group, Long likes, Date newDate, Date oldDate) {
		super();
		Group = group;
		Likes = likes;
		NewDate = newDate;
		OldDate = oldDate;
	}

	public Serializable getGroup() {
		return Group;
	}

	public void setGroup(Serializable group) {
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
