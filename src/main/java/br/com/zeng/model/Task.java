package br.com.zeng.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import br.com.zeng.model.action.Modifiable;

@Entity
@Where(clause = "archived = 0")
public class Task implements Modifiable{
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String name;
	private String description;
	@NotNull
	private boolean archived;
	@NotNull
	private State state;
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@Future
	private DateTime expirationDate;
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime dateOfCompletion;
	@OneToMany(mappedBy = "task")
	private List<Step> steps;
	@ManyToMany
	private List<User> contributors;
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	private TaskList taskList;

	/**
	 * @deprecated hibernate eyes only
	 */
	public Task() {
		this.contributors = new ArrayList<User>();
		this.archived = false;
		this.state = State.TODO;
	}

	public Task(TaskList taskList, String name) {
		this();
		this.taskList = taskList;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public TaskList getTaskList() {
		return taskList;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setContributors(List<User> contributors) {
		this.contributors = contributors;
	}

	public void setExpirationDate(DateTime expirationDate) {
		if(expirationDate != null){
			int year = expirationDate.getYear();
			int monthOfYear = expirationDate.getMonthOfYear();
			int dayOfMonth = expirationDate.getDayOfMonth();
			expirationDate = new DateTime(year,monthOfYear, dayOfMonth,0,0,0,0);
			this.expirationDate = expirationDate;
		}
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<User> getContributors() {
		return contributors;
	}

	public DateTime getExpirationDate() {
		return expirationDate;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public State getState() {
		return state;
	}

	public Project getProject() {
		return taskList.getProject();
	}

	public boolean isFinalized() {
		return state.equals(State.DONE);
	}

	public void start() {
		this.state = State.DOING;
	}
	
	public boolean isStarted() {
		return state.equals(State.DOING);
	}

	public void stop() {
		this.state = State.TODO;
	}

	public boolean isStopped() {
		return state.equals(State.TODO);
	}
	
	public void finalize() {
		DateTime dateTime = new DateTime();
		this.dateOfCompletion = new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(),1,0,0,0,0);
		this.state = State.DONE;
	}

	public DateTime getDateOfCompletion() {
		return dateOfCompletion;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	
	public Category getCategory() {
		return getTaskList().getCategory();
	}

	@Override
	public String getType() {
		return "Task";
	}
	
	public boolean isExpired(){
		if(expirationDate==null) return false;
		return expirationDate.isBefore(new DateTime().minusDays(1));
	}
	
	public boolean isCloseToExpiring(){
		if(expirationDate==null) return false;
		DateTime today = new DateTime();
		Interval interval = new Interval(today.minusDays(1), today.plusWeeks(1));
		return interval.contains(expirationDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}

	
}
